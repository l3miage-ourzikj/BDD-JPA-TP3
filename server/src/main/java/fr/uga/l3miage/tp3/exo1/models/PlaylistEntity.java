package fr.uga.l3miage.tp3.exo1.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.time.Duration;
import java.util.Set;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistEntity {
    @Id
    private String name;

    private String description;

    private Duration totalDuration;

    @ManyToMany(mappedBy = "playLists")
    private Set<SongEntity> songEntities;
}
