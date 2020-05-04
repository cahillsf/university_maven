package hello;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import hello.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {}