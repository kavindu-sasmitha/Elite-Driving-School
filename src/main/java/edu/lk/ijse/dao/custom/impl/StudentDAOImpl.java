package edu.lk.ijse.dao.custom.impl;

import edu.lk.ijse.config.FactoryConfiguration;
import edu.lk.ijse.dao.custom.StudentDAO;
import edu.lk.ijse.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class StudentDAOImpl implements StudentDAO {
    private final FactoryConfiguration factoryConfiguration=FactoryConfiguration.getInstance();


    @Override
    public List<Student> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public String getLastId() throws SQLException {
        return "";
    }

    @Override
    public boolean save(Student student) throws SQLException {
        Session session=factoryConfiguration.getSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.persist(student);
            transaction.commit();
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            session.close();
        }
    }

    @Override
    public boolean update(Student student) throws SQLException {
        Session session=factoryConfiguration.getSession();
        Transaction transaction=session.beginTransaction();
        try{
            session.merge(student);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction !=null) transaction.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean delete(String id) throws SQLException {
        Session session=factoryConfiguration.getSession();
        Transaction transaction=session.beginTransaction();
        try{
            Student student=session.get(Student.class, id);
            if(student!=null){
                session.remove(student);
                transaction.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (transaction !=null) transaction.rollback();
            e.printStackTrace();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public List<String> getAllIds() throws SQLException {
        return List.of();
    }

    @Override
    public Optional<Student> findById(String id) throws SQLException {
        return Optional.empty();
    }
}
