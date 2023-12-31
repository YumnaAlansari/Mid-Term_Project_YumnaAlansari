package SDAIronHack.ArtHouse.Service.interfaces;

import SDAIronHack.ArtHouse.Model.Music;
import java.util.List;
import java.util.Optional;

public interface IMusicService {

    public List<Music> getAllMusic();
    public Optional<Music> getMusicById(Long id);
    public List<Music> getMusicByGenre(String genre);
    public List<Music> getMusicByArtist(String artist);
    public List<Music> getMusicByReleaseYear( int releaseYear);
    void updateMusicById(Music music, Long id);
    void addMusic(Music music);
    void deleteById(Long id);
}
