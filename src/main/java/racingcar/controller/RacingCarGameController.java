package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import racingcar.model.Player;
import racingcar.view.RacingCarGameView;

public class RacingCarGameController {

    private static final int FORWARD_REFERENCE_NUMBER = 4;
    private static final int DEFAULT_LOCATION = 0;
    private static final int MIN_NUM = 0;
    private static final int MAX_NUM = 9;

    private final RacingCarGameView racingCarGameView;

    public RacingCarGameController(RacingCarGameView racingCarGameView) {
        this.racingCarGameView = racingCarGameView;
    }

    public void run() {
        List<Player> playerList = generatePlayer(racingCarGameView.requestCarName());

        int tryNum = racingCarGameView.requestTryNumber();

        racingCarGameView.gameResult();
        for (int i = 0; i < tryNum; i++) {
            for (Player player : playerList) {
                moveOrNot(player, Randoms.pickNumberInRange(MIN_NUM, MAX_NUM));
            }
            racingCarGameView.showNowPlayerLocation(playerList);
        }

        racingCarGameView.showGameWinner(judgeGame(playerList));
    }

    public List<Player> generatePlayer(List<String> playerNamerList) {
        LinkedList<Player> playerList = new LinkedList<>();

        for (String name : playerNamerList) {
            playerList.add(new Player(name, DEFAULT_LOCATION));
        }

        return playerList;
    }

    public void moveOrNot(Player player, int randomNum) {
        if (randomNum >= FORWARD_REFERENCE_NUMBER) {
            player.move();
        }
    }

    public List<Player> judgeGame(List<Player> playerList) {

        int winScore = playerList.stream().max(Comparator.comparingInt(Player::getLocation)).orElseThrow()
                .getLocation();

        return playerList.stream().filter(player -> player.getLocation() == winScore).toList();
    }
}
