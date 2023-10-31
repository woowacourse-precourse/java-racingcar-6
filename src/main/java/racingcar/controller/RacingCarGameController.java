package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
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
        List<Player> playerList = generatePlayer(racingCarGameView.requestCarName());

        int tryNum = racingCarGameView.requestTryNumber();

        racingCarGameView.gameResult();
        for (int i = 0; i < tryNum; i++) {
            moveOrNot(playerList, Randoms.pickNumberInRange(0, 9));
            racingCarGameView.showNowPlayerLocation(playerList);
        }

        racingCarGameView.showGameWinner(judgeGame(playerList));
    }

    public List<Player> generatePlayer(List<String> playerNamerList) {
        LinkedList<Player> playerList = new LinkedList<>();

        for (String name : playerNamerList) {
            playerList.add(new Player(name, 0));
        }

        return playerList;
    }

    public void moveOrNot(List<Player> playerList, int randomNum) {
        for (Player player : playerList) {
            if (randomNum >= 4) {
                player.move();
            }
        }
    }

    public List<Player> judgeGame(List<Player> playerList) {

        int winScore = playerList.stream().max(Comparator.comparingInt(Player::getLocation)).orElseThrow()
                .getLocation();

        return playerList.stream().filter(player -> player.getLocation() == winScore).toList();
    }
}
