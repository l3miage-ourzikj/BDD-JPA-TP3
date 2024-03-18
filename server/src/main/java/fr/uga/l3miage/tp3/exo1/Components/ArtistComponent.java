package fr.uga.l3miage.tp3.exo1.Components;

import fr.uga.l3miage.tp3.exo1.enums.GenreMusical;
import fr.uga.l3miage.tp3.exo1.exceptions.ArtistNotFoundException;
import fr.uga.l3miage.tp3.exo1.models.ArtistEntity;
import fr.uga.l3miage.tp3.exo1.repositories.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArtistComponent {
    private  final ArtistRepository artistRepository;

    public ArtistEntity getArtist(String name) throws  ArtistNotFoundException {
        return artistRepository.findById(name).orElseThrow(()-> new ArtistNotFoundException("Artist not found with given name :"+ name));
    }
    public ArtistEntity createArtist(ArtistEntity artist){

        return artistRepository.save(artist);
    }
    public ArtistEntity updateArtist(ArtistEntity artistDTO) throws ArtistNotFoundException {
        ArtistEntity artistEntity = artistRepository.findById(artistDTO.getName()).orElseThrow(()->new ArtistNotFoundException("Artist not found with given name :"+ artistDTO.getName()));
        artistEntity.setBiography(artistDTO.getBiography());
        artistEntity.setAlbumEntities(artistDTO.getAlbumEntities());
        return artistRepository.save(artistEntity);
    }

    public void deleteArtist(String name){
        artistRepository.deleteById(name);
    }

    public int countArtistsWithGenre(GenreMusical genre){
        return artistRepository.countArtistEntitiesByGenreMusicalEquals(genre);
    }



}
