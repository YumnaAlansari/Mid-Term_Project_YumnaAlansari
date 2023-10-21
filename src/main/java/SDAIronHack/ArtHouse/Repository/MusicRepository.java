package SDAIronHack.ArtHouse.Repository;

import SDAIronHack.ArtHouse.Model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends JpaRepository<Music, Long> {

}
