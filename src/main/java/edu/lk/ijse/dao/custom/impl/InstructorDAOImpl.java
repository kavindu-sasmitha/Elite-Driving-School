package edu.lk.ijse.dao.custom.impl;

import edu.lk.ijse.config.FactoryConfiguration;
import edu.lk.ijse.dao.custom.InstructorDAO;
import edu.lk.ijse.entity.Instructor;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class InstructorDAOImpl implements InstructorDAO {
    private final FactoryConfiguration factoryConfiguration=FactoryConfiguration.getInstance();
    @Override
    public List<Instructor> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public String getLastId() throws SQLException {
        return "";
    }

    @Override
    public boolean save(Instructor instructor) throws SQLException {
        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.persist(instructor);
            transaction.commit();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            session.close();
        }
    }

    @Override
    public boolean update(Instructor instructor) throws SQLException {
        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.merge(instructor);
            transaction.commit();
            return true;
        }catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean delete(String id) throws SQLException {
        Session session = factoryConfiguration.getSession();
        Transaction tx = session.beginTransaction();
        try {
            Instructor instructor = session.get(Instructor.class, id);
            if (instructor != null) {
                session.remove(instructor);
                tx.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public List<String> getAllIds() throws SQLException {
        return List.of();
    }

    @Override
    public Optional<Instructor> findById(String id) throws SQLException {
        return Optional.empty();
    }
}
