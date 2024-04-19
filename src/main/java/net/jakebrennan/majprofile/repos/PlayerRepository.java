package net.jakebrennan.majprofile.repos;

import net.jakebrennan.majprofile.models.Player;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlayerRepository extends CrudRepository<Player, Long> {
    List<Player> findByName(String name);
    List<Player> findByDisplayName(String displayName);
}
