package fantasy.controller;

import fantasy.model.Character;
import fantasy.model.CharacterAbilities;
import fantasy.model.CharacterRaseAndClass;
import fantasy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import fantasy.servis.CharacterService;

import java.util.Set;


@RestController
@RequestMapping("/api/character")
public class CharacterController {

    private CharacterService characterService;

    @Autowired
    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @PostMapping
    public void create(@RequestParam User user,
                       @RequestParam String name,
                       @RequestParam String description,
                       @RequestParam CharacterAbilities characterAbilities,
                       @RequestParam CharacterRaseAndClass characterRaseAndClass){
        characterService.create(user, description, name, characterAbilities, characterRaseAndClass);

    }

    @GetMapping
    public Set<Character> findAll(){
        return characterService.findAll();
    }

    @GetMapping
    public Set<Character> findAllByName(@PathVariable String name){
        return characterService.findAllByName(name);
    }

    @GetMapping
    public Set<Character> findAllByRaceAndClass(@PathVariable CharacterRaseAndClass characterRaseAndClass){
        return characterService.findAllByCharacterRaseAndClass(characterRaseAndClass);
    }

}