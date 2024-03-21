/*
 * You can use the following import statements
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.jdbc.core.JdbcTemplate;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.ArrayList;
 * 
 */

// Write your code here
package com.example.player.service;

import com.example.player.model.Player;
import com.example.player.repository.PlayerRepository;
import com.example.player.model.PlayerRowMapper;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class PlayerH2Service implements PlayerRepository {
   @Autowired
   private JdbcTemplate db;

   @Override
   public ArrayList<Player> getPlayers() {
      List<Player> pl1 = db.query("Select * from TEAM", new PlayerRowMapper());
      ArrayList<Player> arlst1 = new ArrayList<>(pl1);
      return arlst1;
   }

   @Override
   public Player getPlayerByPlayerId(int playerId) {
      try {
         Player p1 = db.queryForObject("Select * from TEAM where id=?", new PlayerRowMapper(), playerId);
         return p1;
      } catch (Exception e) {
         throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      }
   }

   @Override
   public Player addPlayer(Player player) {
      db.update("Insert into TEAM (playerName,jerseyNumber,role)values(???)",
            player.getPlayerName(), player.getJerseyNumber(), player.getRole());
      Player sp = db.queryForObject("Select * from TEAM where playerName = ?,jerseyNumber=?,role=?",
            new PlayerRowMapper(), player.getPlayerName(), player.getJerseyNumber(), player.getRole());
      return sp;
   }
}