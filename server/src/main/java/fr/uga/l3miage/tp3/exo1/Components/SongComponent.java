package fr.uga.l3miage.tp3.exo1.Components;

import fr.uga.l3miage.tp3.exo1.exceptions.SongNotFoundException;
import fr.uga.l3miage.tp3.exo1.exceptions.UserNotFoundException;
import fr.uga.l3miage.tp3.exo1.models.SongEntity;
import fr.uga.l3miage.tp3.exo1.models.UserEntity;
import fr.uga.l3miage.tp3.exo1.repositories.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class SongComponent {
    private final SongRepository songRepository;
    public SongEntity getSong(String title) throws SongNotFoundException {
        return songRepository.findById(title).orElseThrow(()->new SongNotFoundException("no song found with given title :"+title));
    }
    public SongEntity createSong(SongEntity song){
        return songRepository.save(song);
    }
    public SongEntity updateSong(SongEntity song) throws UserNotFoundException {
        SongEntity songEntity = songRepository.findById(song.getTitle()).orElseThrow(()->new UserNotFoundException("no song found with given title :"+song.getTitle()));
        songEntity.setDuration(song.getDuration());
        return songRepository.save(songEntity);
    }
    public void deleteSong(String name){
        songRepository.deleteById(name);
    }
    public Set<SongEntity> getSongIsInDuration(Duration durationMin,Duration durationMax){
        return songRepository.findAllByDurationBetween(durationMin,durationMax);
    }
}
