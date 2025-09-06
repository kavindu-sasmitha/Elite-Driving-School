package edu.lk.ijse.dao.custom.impl;

import edu.lk.ijse.config.FactoryConfiguration;
import edu.lk.ijse.dao.custom.LessonDAO;
import edu.lk.ijse.entity.Lesson;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class LessonDAOImpl implements LessonDAO {
    private final FactoryConfiguration factoryConfiguration=FactoryConfiguration.getInstance();
    @Override
    public List<Lesson> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public String getLastId() throws SQLException {
        return "";
    }

    @Override
    public boolean save(Lesson lesson) throws SQLException {
        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.persist(lesson);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean update(Lesson lesson) throws SQLException {
        Session session = factoryConfiguration.getSession();
        Transaction tx = session.beginTransaction();
        try {
            session.merge(lesson);
            tx.commit();
            return true;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean delete(String id) throws SQLException {
        Session session = factoryConfiguration.getSession();
        Transaction transaction = session.beginTransaction();

        try {
            Lesson lesson = session.get(Lesson.class, id);
            if (lesson != null) {
                session.remove(lesson);
                transaction.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
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
    public Optional<Lesson> findById(String id) throws SQLException {
        return Optional.empty();
    }
}
