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
@Table(name = "teachers")
public class Teacher extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String lastname;

    public Teacher(String firstname, String lastname, Boolean isActive) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.setIsActive(isActive);
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Getter(AccessLevel.PROTECTED)
    @ManyToMany
    @JoinTable(
            name = "course",
            joinColumns = @JoinColumn(name = "teacher_id", referencedColumnName = "id",nullable = false),
            inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id",nullable = false)
    )
    private Set<Student> students = new HashSet<>();

    public void addUser(User user) {
        this.user = user;
        user.setTeacher(this);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", user=" + user +
                '}' + "AbstractEntity{" +
                "createdAt=" + getCreatedAt() +
                ", updatedAt=" + getUpdatedAt() +
                ", isActive=" + getIsActive() +
                '}';
    }
}
