package fr.uga.l3miage.tp3.exo1.repositories;

import fr.uga.l3miage.tp3.exo1.models.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Duration;
import java.util.Set;

@Repository
public interface SongRepository extends JpaRepository<SongEntity,String> {
    public Set<SongEntity>findAllByDurationBetween(Duration min,Duration max);

}
