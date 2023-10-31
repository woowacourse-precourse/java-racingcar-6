package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
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
        String[] playerNames = racingCarGameView.requestCarName().split(",");
        List<Player> playerList = generatePlayer(Arrays.stream(playerNames).toList());

        for (int i=0; i< racingCarGameView.requestTryNumber(); i++) {

        }
    }

    public List<Player> generatePlayer(List<String> playerNamerList) {
        LinkedList<Player> playerList = new LinkedList<>();

        for (String name : playerNamerList) {
            playerList.add(new Player(name, 0));
        }

        return playerList;
    }

    public void moveOrNot(List<Player> playerList) {
        int enoughMove;
        for (Player player : playerList) {
            enoughMove = Randoms.pickNumberInRange(0,9);
            if (enoughMove >= 4) {
                player.move();
            }
        }
    }
}
