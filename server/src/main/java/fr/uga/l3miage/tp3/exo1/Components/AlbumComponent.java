package fr.uga.l3miage.tp3.exo1.Components;

import fr.uga.l3miage.tp3.exo1.enums.GenreMusical;
import fr.uga.l3miage.tp3.exo1.exceptions.AlbumNotFoundException;
import fr.uga.l3miage.tp3.exo1.exceptions.ArtistNotFoundException;
import fr.uga.l3miage.tp3.exo1.models.AlbumEntity;
import fr.uga.l3miage.tp3.exo1.models.ArtistEntity;
import fr.uga.l3miage.tp3.exo1.repositories.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class AlbumComponent {
    private final AlbumRepository albumRepository;
    public AlbumEntity getAlbum(String title) throws AlbumNotFoundException {
        return albumRepository.findById(title).orElseThrow(()-> new AlbumNotFoundException("Album not found with given title :"+ title));
    }
    public AlbumEntity createAlbum(AlbumEntity artist){
        return albumRepository.save(artist);
    }
    public AlbumEntity updateAlbum(AlbumEntity albumDTO) throws AlbumNotFoundException {
        AlbumEntity albumEntity = albumRepository.findById(albumDTO.getTitle()).orElseThrow(()->new AlbumNotFoundException("Album not found with given title :"+ albumDTO.getTitle()));
        albumEntity.setSongEntities(albumDTO.getSongEntities());
        return albumRepository.save(albumEntity);
    }

    public void deleteAlbum(String title){
        albumRepository.deleteById(title);
    }

    public Set<AlbumEntity> AlbumsFromGivenArtist(ArtistEntity artist){
        return albumRepository.findAllByArtistEntity_Name(artist.getName());
    }


}
