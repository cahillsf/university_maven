package hello;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.EntityListeners;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "student")
@EntityListeners(AuditingEntityListener.class)
public class Student {

	/*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)*/
    @Id
    @Column(name = "Id", nullable = false)
    private int id;
    @Column(name = "Firstname", nullable = false)
    private String firstName;
    @Column(name = "Lastname", nullable = false)
    private String lastName;
    @Column(name = "Emailaddr", nullable = false)
    private String emailAddr;
    @Column(name = "Major", nullable = false)
    private String major;

    public int getId(){
    	return id;
    }

    public String getFirstName(){
    	return firstName;
    }

    public String getLastName(){
    	return lastName;
    }

    public String getEmailAddr(){
    	return emailAddr;
    }

    public String getMajor(){
    	return major;
    }

}