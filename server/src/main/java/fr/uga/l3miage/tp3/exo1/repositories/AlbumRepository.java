package fr.uga.l3miage.tp3.exo1.repositories;

import fr.uga.l3miage.tp3.exo1.models.AlbumEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface AlbumRepository extends JpaRepository<AlbumEntity,String> {
    public Set<AlbumEntity> findAllByArtistEntity_Name(String name);
}
