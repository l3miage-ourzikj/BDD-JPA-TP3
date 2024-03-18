package fr.uga.l3miage.tp3.exo1.Components;

import fr.uga.l3miage.tp3.exo1.exceptions.PlaylistNotFoundException;
import fr.uga.l3miage.tp3.exo1.exceptions.SongNotFoundException;
import fr.uga.l3miage.tp3.exo1.exceptions.UserNotFoundException;
import fr.uga.l3miage.tp3.exo1.models.PlaylistEntity;
import fr.uga.l3miage.tp3.exo1.models.PlaylistEntity;
import fr.uga.l3miage.tp3.exo1.models.SongEntity;
import fr.uga.l3miage.tp3.exo1.repositories.PlaylistRepository;
import fr.uga.l3miage.tp3.exo1.repositories.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class PlaylistComponent {
    private final PlaylistRepository playlistRepository;

    public PlaylistEntity getSong(String name) throws PlaylistNotFoundException {
        return playlistRepository.findById(name).orElseThrow(()->new PlaylistNotFoundException("no playlist found with given name :"+name));
    }
    public PlaylistEntity createPlaylist(PlaylistEntity playlist){
        return playlistRepository.save(playlist);
    }
    public PlaylistEntity updatePlaylist(PlaylistEntity playlist) throws UserNotFoundException {
        PlaylistEntity playlistEntity = playlistRepository.findById(playlist.getName()).orElseThrow(()->new UserNotFoundException("no playlist found with given name :"+playlist.getName()));
        playlistEntity.setDescription(playlist.getDescription());
        playlistEntity.setSongEntities(playlist.getSongEntities());
        return playlistRepository.save(playlistEntity);
    }

    public void deletePlaylist(String name){
        playlistRepository.deleteById(name);
    }
    public Set<PlaylistEntity> getPlaylistContainingSong(SongEntity song){
        return playlistRepository.findAllBySongEntitiesContains(song);
    }
}
