package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
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

        int tryNum = racingCarGameView.requestTryNumber();

        racingCarGameView.gameResult();
        for (int i = 0; i < tryNum; i++) {
            moveOrNot(playerList);
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

    public void moveOrNot(List<Player> playerList) {
        int enoughMove;
        for (Player player : playerList) {
            enoughMove = Randoms.pickNumberInRange(0,9);
            if (enoughMove >= 4) {
                player.move();
            }
        }
    }

    public List<Player> judgeGame(List<Player> playerList) {

        int winScore = playerList.stream().max(Comparator.comparingInt(Player::getLocation))
                .orElseThrow().getLocation();

        return playerList.stream().filter(player -> player.getLocation() == winScore).toList();
    }
}
