package SDAIronHack.ArtHouse.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Theatre extends ArtHouse{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "play_wright")
    private String playWright;
    @Column(name = "number_of_actors")
    private int numberOfActors;
    private String category;


}