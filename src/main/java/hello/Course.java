package hello;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.EntityListeners;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "course")
@EntityListeners(AuditingEntityListener.class)
public class Course {

	/*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)*/
    @Id
    @Column(name = "Crn", nullable = false)
    private int id;
    @Column(name = "Subject", nullable=false)
    private String subject;
    @Column(name = "Coursenumber", nullable = false)
    private int courseNo;
    @Column(name = "Title", nullable=false)
    private String title;
    @Column(name = "Credits", nullable = false)
    private int credits;


    public int getCrn(){
    	return id;
    }

    public String getSubject(){
    	return subject;
    }

    public int getCourseNo(){
    	return courseNo;
    }

    public String getTitle(){
    	return title;
    }

    public int getCredits(){
    	return credits;
    }


}