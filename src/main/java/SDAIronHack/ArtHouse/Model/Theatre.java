package SDAIronHack.ArtHouse.Model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Theatre extends ArtHouse {

    @Id
    private Long id;
    private String playwright;
    private int numberOfActors;
    private String category;

    @ManyToOne
    @JoinColumn(name = "artHouse_id")
    private ArtHouse artHouse;

    public Theatre(){}

    public Theatre(Long id, String playwright, int numberOfActors, String category, ArtHouse artHouse) {
        this.id = id;
        this.playwright = playwright;
        this.numberOfActors = numberOfActors;
        this.category = category;
        this.artHouse = artHouse;
    }
}