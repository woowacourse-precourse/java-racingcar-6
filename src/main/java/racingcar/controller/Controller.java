package racingcar.controller;

import racingcar.model.Player;

import java.util.List;

public interface Controller {
    boolean addPlayer();
    boolean removePlayer();
    List<Player> getPlayers();
}
