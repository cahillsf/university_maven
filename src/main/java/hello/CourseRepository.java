package hello;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hello.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {}