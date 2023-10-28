package racingcar.controller;

import racingcar.model.RacingPlayer;

import java.util.ArrayList;
import java.util.List;

public class RacingPlayerController implements Controller{
    private List<RacingPlayer> playerList = new ArrayList<>();
    @Override
    public boolean addPlayer(String name) {
        RacingPlayer racingPlayer = new RacingPlayer(name);
        if (!playerList.contains(racingPlayer)){
            playerList.add(racingPlayer);
            return true;
        }
        return false;
    }
    @Override
    public boolean removePlayer(String name) {
        RacingPlayer racingPlayer = new RacingPlayer(name);
        return playerList.remove(racingPlayer);
    }

    @Override
    public List getPlayers() {
        return playerList;
    }

}
