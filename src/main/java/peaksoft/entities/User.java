package peaksoft.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * @author Mukhammed Asantegin
 */
@Entity
@Table(name = "users")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    @SequenceGenerator(name = "user_gen", sequenceName = "user_seq", allocationSize = 1, initialValue = 4)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Favorite favorite;

    @PrePersist
    public void preSave(){
        this.createdAt = LocalDate.now();
    }

    @PreUpdate
    public void preUpdate(){
        this.updatedAt = LocalDate.now();
    }



}
