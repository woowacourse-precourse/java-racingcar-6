package racingcar.controller;

import java.util.LinkedList;
import java.util.List;
import racingcar.model.Player;
import racingcar.view.RacingCarGameView;

public class RacingCarGameController {

    private final RacingCarGameView racingCarGameView;

    public RacingCarGameController(RacingCarGameView racingCarGameView) {
        this.racingCarGameView = racingCarGameView;
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
