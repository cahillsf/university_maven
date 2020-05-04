package hello;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
//import java.lang.Exception;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/test")
public class MainController {

    @Autowired
  private StudentRepository studentRepository;
  /**
   * Get all users list.
   *
   // @return the list
   */
  //@CrossOrigin(origins = "http://localhost:80")
  @GetMapping("/student")
  public List<Student> getAllUsers() {
    return studentRepository.findAll();
  }

  @GetMapping("/student/{id}")
  public ResponseEntity<Student> getUsersById(@PathVariable(value = "id") Integer userId)
    {
      //throws ResourceNotFoundException {
    Optional<Student> optionalPaper =
        studentRepository.findById(userId);
        Student student =  optionalPaper.get();
            //.orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
    return ResponseEntity.ok().body(student);
  }


}