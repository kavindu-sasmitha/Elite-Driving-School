package edu.icet.elite.dao;

import edu.icet.elite.entity.Lesson;
import java.util.List;
import java.util.Optional;

public interface LessonDao {
    void save(Lesson lesson);
    Optional<Lesson> findById(Integer id);
    List<Lesson> findAll();
    void update(Lesson lesson);
    void delete(Lesson lesson);
}
