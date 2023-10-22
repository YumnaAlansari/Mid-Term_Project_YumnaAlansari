package SDAIronHack.ArtHouse.Service.impl;


import SDAIronHack.ArtHouse.Model.Music;
import SDAIronHack.ArtHouse.Repository.MusicRepository;
import SDAIronHack.ArtHouse.Service.interfaces.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpMultiply;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MusicService implements IMusicService {

    @Autowired
    MusicRepository musicRepository;

    @Override
    public List<Music> getAllMusic() {
        return musicRepository.findAll();
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
    public Optional<Music> getMusicByArtist(String artist) {
        return musicRepository.findMusicByArtist(artist);
    }

    @Override
    public List<Music> getMusicByReleaseYear(int releaseYear) {
        return musicRepository.findMusicByReleaseYear(releaseYear);
    }
}
