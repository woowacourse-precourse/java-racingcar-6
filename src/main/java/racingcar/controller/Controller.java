package racingcar.controller;

import racingcar.model.Player;
import racingcar.model.RacingPlayer;

import java.util.List;

public interface Controller {
    boolean addPlayer(String playerName);
    boolean removePlayer(String playerName);
    List getPlayers();
}
