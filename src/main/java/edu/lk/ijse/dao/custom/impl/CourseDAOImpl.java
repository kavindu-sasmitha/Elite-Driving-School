package edu.lk.ijse.dao.custom.impl;

import edu.lk.ijse.config.FactoryConfiguration;
import edu.lk.ijse.dao.custom.CourseDAO;
import edu.lk.ijse.entity.Course;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CourseDAOImpl implements CourseDAO {
    private final FactoryConfiguration factoryConfiguration=FactoryConfiguration.getInstance();
    @Override
    public List<Course> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public String getLastId() throws SQLException {
        return "";
    }

    @Override
    public boolean save(Course course) throws SQLException {
        Session session=factoryConfiguration.getSession();
        Transaction transaction=session.beginTransaction();
        try {
            session.persist(course);
            transaction.commit();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            session.close();
        }
    }

    @Override
    public boolean update(Course course) throws SQLException {
        Session session=factoryConfiguration.getSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.merge(course);
            transaction.commit();
            return true;
        }catch(Exception e){
            if (transaction != null) transaction.rollback();{
                e.printStackTrace();
                return false;
            }

        }finally {
            session.close();
        }
    }

    @Override
    public boolean delete(String id) throws SQLException {
        Session session=factoryConfiguration.getSession();
        Transaction transaction=session.beginTransaction();
        try{
            Course course=session.get(Course.class, id);
            if(course!=null){
                session.remove(course);
                transaction.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();{
                e.printStackTrace();
                return false;
            }
        }finally {
            session.close();
        }
    }

    @Override
    public List<String> getAllIds() throws SQLException {
        return List.of();
    }

    @Override
    public Optional<Course> findById(String id) throws SQLException {
        return Optional.empty();
    }
}
