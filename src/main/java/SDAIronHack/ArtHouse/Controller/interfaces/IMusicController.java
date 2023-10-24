package SDAIronHack.ArtHouse.Controller.interfaces;

import SDAIronHack.ArtHouse.Model.Music;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface IMusicController {


    public List<Music> getAllMusic();
    public Optional<Music> getMusicById(Long id);
    public List<Music> getMusicByGenre(String genre);
    public List<Music> getMusicByArtist(String artist);
    public List<Music> getMusicByReleaseYear(int releaseYear);
    public void addMusic(Music music);
    public void updateMusicById(Music music, Long id) ;
    public void deleteMusicById(Long id);

}
