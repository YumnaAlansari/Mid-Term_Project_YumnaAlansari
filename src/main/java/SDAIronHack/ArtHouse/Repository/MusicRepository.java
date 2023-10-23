package SDAIronHack.ArtHouse.Repository;

import SDAIronHack.ArtHouse.Model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MusicRepository extends JpaRepository<Music, Long> {

    List<Music> findMusicByGenre(String genre);
    List<Music> findMusicByArtist(String artist);
    List<Music> findMusicByReleaseYear(int releaseYear);


}
