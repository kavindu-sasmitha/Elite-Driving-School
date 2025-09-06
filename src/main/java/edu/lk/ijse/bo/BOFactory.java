package edu.lk.ijse.bo;

import edu.lk.ijse.bo.custom.impl.CourseBOImpl;
import edu.lk.ijse.bo.custom.impl.InstructorBOImpl;
import edu.lk.ijse.bo.custom.impl.LessonBOImpl;
import edu.lk.ijse.bo.custom.impl.StudentBOImpl;

public class BOFactory {
    private static BOFactory  boFactory;
    private BOFactory() {}
    public static BOFactory getInstance() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }
    public <T extends SuperBO> T getBO(BOTypes boType) {
        return switch (boType) {
            case STUDENTBO -> (T) new StudentBOImpl();

            case INSTRUCTORBO -> (T)  new InstructorBOImpl();
            case COURSEBO -> (T) new CourseBOImpl();
            case LESSONBO -> (T) new LessonBOImpl();
        };
    }
}
