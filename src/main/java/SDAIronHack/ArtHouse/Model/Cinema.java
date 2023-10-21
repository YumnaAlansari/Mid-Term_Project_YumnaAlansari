package SDAIronHack.ArtHouse.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Cinema extends ArtHouse {

    @Id
    private Long id;
    private String director;
    private int numberOfActors;
    private int releaseYear;
    private String category;
    private String productionCompany;
    @ManyToOne
    @JoinColumn(name = "artHouse_id")
    private ArtHouse artHouse;

    public Cinema(){}

    public Cinema(Long id, String director, int numberOfActors, int releaseYear, String category, String productionCompany, ArtHouse artHouse) {
        this.id = id;
        this.director = director;
        this.numberOfActors = numberOfActors;
        this.releaseYear = releaseYear;
        this.category = category;
        this.productionCompany = productionCompany;
        this.artHouse = artHouse;
    }
}
