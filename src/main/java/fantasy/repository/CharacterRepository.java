package fantasy.repository;


import fantasy.model.Character;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CharacterRepository extends CrudRepository<Character, Long> {

    void create(String user, String description );
    Set<Character> findCharacterBy(Long characterId);
}