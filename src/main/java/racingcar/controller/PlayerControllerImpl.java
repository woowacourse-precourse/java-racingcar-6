package racingcar.controller;

import racingcar.model.Vehicle;
import racingcar.model.StandardCar;

import java.util.ArrayList;
import java.util.List;

public class PlayerControllerImpl implements PlayerController {
    private List<Vehicle> playerList = new ArrayList<>();

    @Override
    public List addAllPlayer(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            addPlayer(list.get(i));
        }
        return playerList;
    }

    @Override
    public void addPlayer(String name) {
        Vehicle racingPlayer = new StandardCar(name);
        if (!playerList.contains(racingPlayer)) {
            playerList.add(racingPlayer);
        }
    }

    @Override
    public boolean removePlayer(String name) {
        StandardCar racingPlayer = new StandardCar(name);
        return playerList.remove(racingPlayer);
    }

    @Override
    public List getPlayers() {
        return playerList;
    }

    @Override
    public void clearPlayer() {
        playerList.clear();
    }

}
