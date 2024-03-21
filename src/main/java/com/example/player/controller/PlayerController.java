/*
 * 
 * You can use the following import statemets
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */
package com.example.player.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;

import com.example.player.service.PlayerH2Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.player.model.Player;

@RestController
public class PlayerController {
    @Autowired
    public PlayerH2Service ps;

    @GetMapping("/players")

    public ArrayList<Player> getPlayers() {
        return ps.getPlayers();
    }

    @GetMapping("/players/{playerId}")
    public Player getPlayerByPlayerId(@PathVariable("playerId") int playerId) {
        return ps.getPlayerByPlayerId(playerId);
    }

}
