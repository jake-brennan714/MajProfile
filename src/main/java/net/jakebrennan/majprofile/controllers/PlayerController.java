package net.jakebrennan.majprofile.controllers;

import net.jakebrennan.majprofile.models.Player;
import net.jakebrennan.majprofile.repos.PlayerRepository;
import net.jakebrennan.majprofile.exceptions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping
    public Iterable findAll() {
        return playerRepository.findAll();
    }

    @GetMapping("/search?name={name}")
    public List findByName(@PathVariable String name) {
        return playerRepository.findByName(name);
    }

    @GetMapping("/search?disp={dname}")
    public List findByDisplayName(@PathVariable String dname) {
        return playerRepository.findByDisplayName(dname);
    }

    @GetMapping("/player/{id}")
    public Player findById(@PathVariable int id) {
        return playerRepository.findById((long) id)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found"));
    }
}
