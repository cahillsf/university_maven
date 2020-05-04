package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.cfg.Configuration;
import org.springframework.http.ResponseEntity;
import java.util.Optional;


@RestController
@RequestMapping("/test")
public class EnrollmentController {

    @Autowired
 
  private CourseRepository courseRepository;
  /**
   * Get all users list.
   *
   // @return the list
   */
  @GetMapping("/student/{id}/enrollments")
  public List<Enrollment> getEnrollment(@PathVariable(value = "id") Integer userId)
    {
      //creating session. This you can create in your own way.
      Configuration cfg = new Configuration();
      cfg.configure("hibernate.cfg.xml");
      cfg.addAnnotatedClass(Enrollment.class);

      SessionFactory factory = cfg.buildSessionFactory();
      Session session = factory.openSession();

      //**creating CriteriaBuilder**
      CriteriaBuilder builder = session.getCriteriaBuilder();
      CriteriaQuery<Enrollment> criteria = builder.createQuery(Enrollment.class);
      Root<Enrollment> enrollmentRoot=criteria.from(Enrollment.class);
      criteria.select(enrollmentRoot);

      //**Adding where clause**
      criteria.where(builder.equal(enrollmentRoot.get("studentId"), userId));
      List<Enrollment> employeeList=session.createQuery(criteria).getResultList();

      return employeeList;
  }

  @GetMapping("/student/{id}/enrollments/{cid}")
  public ResponseEntity<Course> getCourseById(@PathVariable(value = "cid") Integer course)
    {
      
    Optional<Course> optionalCourse =
        courseRepository.findById(course);
        Course course2 =  optionalCourse.get();
          
    return ResponseEntity.ok().body(course2);
  }
}