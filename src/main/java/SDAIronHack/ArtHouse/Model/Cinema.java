package SDAIronHack.ArtHouse.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cinema extends ArtHouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String director;
    @Column(name = "number_of_actors")
    private int numberOfActors;
    @Column(name = "release_year")
    private int releaseYear;
    private String category;
}
