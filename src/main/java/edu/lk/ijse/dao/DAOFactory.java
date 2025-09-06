package edu.lk.ijse.dao;

import edu.lk.ijse.dao.custom.impl.StudentDAOImpl;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory() {
        
    }
    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }
    public <T extends SuperDAO> T getDAO(DAOType daoType) {
        return switch (daoType) {
            case STUDENT -> (T) new StudentDAOImpl();

            case COURSE -> null;
            case LESSON -> null;
            case INSTRUCTOR -> null;
        };
    }
}
