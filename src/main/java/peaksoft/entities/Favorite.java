package peaksoft.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mukhammed Asantegin
 */
@Entity
@Table(name = "favorites")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter @Setter
public class Favorite {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fav_gen")
    @SequenceGenerator(name = "fav_gen", sequenceName = "fav_seq", allocationSize = 1)
    private Long id;
    @ElementCollection
    private List<Long> favoriteUsersId = new ArrayList<>();
}
