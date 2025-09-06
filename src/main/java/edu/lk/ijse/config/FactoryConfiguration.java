package edu.lk.ijse.config;

import edu.lk.ijse.entity.Course;
import edu.lk.ijse.entity.Instructor;
import edu.lk.ijse.entity.Lesson;
import edu.lk.ijse.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {
    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration() {
        Configuration configuration = new Configuration();
        configuration.configure(); // 1 (xml) load configuration

        // 2 add entity classes
        configuration.addAnnotatedClass(Student.class);
        configuration.addAnnotatedClass(Course.class);
        configuration.addAnnotatedClass(Lesson.class);
        configuration.addAnnotatedClass(Instructor.class);

        // 3 create session factory
        sessionFactory = configuration.buildSessionFactory();
    }

    public static FactoryConfiguration getInstance() {
        return factoryConfiguration == null ?
                factoryConfiguration = new FactoryConfiguration()
                :
                factoryConfiguration;
    }

    public Session getSession() {
        Session session = sessionFactory.openSession();
        return session;
    }

}
