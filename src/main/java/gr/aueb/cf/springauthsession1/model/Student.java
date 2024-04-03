package gr.aueb.cf.springauthsession1.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;

    public Student(String firstname,String lastname, Boolean isActive) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.setIsActive(isActive);
    }

    @OneToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Getter(AccessLevel.PROTECTED)
    @ManyToMany(mappedBy = "students")
    private Set<Teacher> teachers = new HashSet<>();

    public void addUser(User user){
        this.setUser(user);
        user.setStudent(this);
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", user=" + user +
                '}';
    }
}
