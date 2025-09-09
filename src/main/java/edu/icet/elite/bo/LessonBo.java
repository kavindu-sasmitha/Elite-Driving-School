package edu.icet.elite.bo;

import edu.icet.elite.dto.LessonDto;
import edu.icet.elite.exception.SchedulingConflictException;

import java.util.List;

public interface LessonBo {
    void scheduleLesson(LessonDto lessonDto) throws SchedulingConflictException;
    void rescheduleLesson(Integer lessonId, LessonDto lessonDto) throws SchedulingConflictException;
    void cancelLesson(Integer lessonId);
    List<LessonDto> getAllLessons();
    List<LessonDto> getLessonsByStudent(Integer studentId);
}
