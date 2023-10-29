package racingcar.logic;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;
import racingcar.repository.Player;
import racingcar.view.PlayersPrint;

public class RacingGameLogic {
    PlayersPrint playersPrint = new PlayersPrint();
    public Map<String, Integer> forwardLogic(Map<String, Integer> players, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            for (String playerName : players.keySet()) {
                int score = players.get(playerName);
                int forward = Randoms.pickNumberInRange(0, 9);
                if (forward > 3) {
                    Player player = new Player(playerName, score);
                    player.scorePlus();
                    players.put(playerName, player.getScore());
                }
            }
            playersPrint.print(players);
            System.out.println();
        }
        return players;
    }
}
