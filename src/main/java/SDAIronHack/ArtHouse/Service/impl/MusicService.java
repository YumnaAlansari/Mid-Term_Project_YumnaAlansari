package SDAIronHack.ArtHouse.Service.impl;


import SDAIronHack.ArtHouse.Model.Cinema;
import SDAIronHack.ArtHouse.Model.Music;
import SDAIronHack.ArtHouse.Repository.MusicRepository;
import SDAIronHack.ArtHouse.Service.interfaces.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class MusicService implements IMusicService {

    @Autowired
    MusicRepository musicRepository;

    @Override
    public List<Music> getAllMusic() {
        List<Music> musicList = musicRepository.findAll();
        if (musicList.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The music list not found");
        return musicList;
    }

    @Override
    public Optional<Music> getMusicById(Long id) {
        return musicRepository.findById(id);
    }

    @Override
    public List<Music> getMusicByGenre(String genre) {
        return musicRepository.findMusicByGenre(genre);
    }

    @Override
    public List<Music> getMusicByArtist(String artist) {
        return musicRepository.findMusicByArtist(artist);
    }

    @Override
    public List<Music> getMusicByReleaseYear(int releaseYear) {
        return musicRepository.findMusicByReleaseYear(releaseYear);
    }

    @Override
    public void updateMusicById(Music music, Long id) {
        music.setId(id);
        musicRepository.save(music);
    }



}
