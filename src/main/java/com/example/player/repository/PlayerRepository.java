package com.example.player.repository;

import com.example.player.model.Player;
import java.util.ArrayList;

public interface PlayerRepository {
    public ArrayList<Player> getPlayers();

    public Player getPlayerByPlayerId(int playerId);

    public Player addPlayer(Player player);
}