package racingcar.controller;

import java.util.List;

public interface Controller {
    boolean addPlayer();
    boolean removePlayer();
    List<String> getPlayers();
}
