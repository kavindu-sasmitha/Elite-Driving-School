package edu.icet.elite.bo;

import edu.icet.elite.dao.CourseDao;
import edu.icet.elite.dao.CourseDaoImpl;
import edu.icet.elite.dao.InstructorDao;
import edu.icet.elite.dao.InstructorDaoImpl;
import edu.icet.elite.dao.StudentDao;
import edu.icet.elite.dao.StudentDaoImpl;

public class DashBoardBoImpl implements DashBoardBo {

    private final StudentDao studentDao = new StudentDaoImpl();
    private final InstructorDao instructorDao = new InstructorDaoImpl();
    private final CourseDao courseDao = new CourseDaoImpl();

    @Override
    public long getStudentCount() {
        // This would be more efficient with a dedicated count method in the DAO.
        return studentDao.findAll().size();
    }

    @Override
    public long getInstructorCount() {
        return instructorDao.findAll().size();
    }

    @Override
    public long getCourseCount() {
        return courseDao.countAllCourses();
    }
}
