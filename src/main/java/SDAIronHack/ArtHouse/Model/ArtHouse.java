package SDAIronHack.ArtHouse.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;

@Entity
@Data
@Inheritance(strategy = InheritanceType.JOINED)
public class ArtHouse {

    @Id
    private Long id;
    private String name;
    private String description;
    private double duration;
    // private double rating;
    public ArtHouse() {}

    public ArtHouse(Long id, String name, String description, double duration) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.duration = duration;
    }
}
