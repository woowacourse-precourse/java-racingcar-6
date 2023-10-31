package racingcar.controller;

import java.util.LinkedList;
import java.util.List;
import racingcar.model.Player;

public class RacingCarGameController {

    public RacingCarGameController() {

    }

    public void run() {

    }

    public List<Player> generatePlayer(List<String> playeNamerList) {
        LinkedList<Player> playerList = new LinkedList<>();

        for (String name : playeNamerList) {
            playerList.add(new Player(name, 0));
        }

        return playerList;
    }
}
