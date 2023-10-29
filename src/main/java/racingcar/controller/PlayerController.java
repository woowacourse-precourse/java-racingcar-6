package racingcar.controller;

import java.util.List;

public interface PlayerController {
    List addAllPlayer(List<String> list);

    void addPlayer(String playerName);

    boolean removePlayer(String playerName);

    List getPlayers();

    void clearPlayer();
}
