package SDAIronHack.ArtHouse.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Music extends ArtHouse {

    @Id
    private Long id;
    // "rock", "pop", "jazz"
    private String genre;
    private String artist;
    private int releaseYear;
    private boolean isFavorite;
    @ManyToOne
    @JoinColumn(name = "artHouse_id")
    private ArtHouse artHouse;

    public Music(){}
    public Music(Long id, String genre, String artist, int releaseYear, boolean isFavorite, ArtHouse artHouse) {
        this.id = id;
        this.genre = genre;
        this.artist = artist;
        this.releaseYear = releaseYear;
        this.isFavorite = isFavorite;
        this.artHouse = artHouse;
    }


}
