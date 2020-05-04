package hello;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.EntityListeners;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "enrollment")
@EntityListeners(AuditingEntityListener.class)
public class Enrollment {

	/*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)*/
    @Id
    @Column(name = "Id", nullable = false)
    private int id;
    @Column(name = "Student_id", nullable = false)
    private int studentId;
    @Column(name = "Course_id", nullable = false)
    private int courseId;


    public int getId(){
    	return id;
    }

    public int getStudentId(){
    	return studentId;
    }

    public int getCourseId(){
    	return courseId;
    }


}