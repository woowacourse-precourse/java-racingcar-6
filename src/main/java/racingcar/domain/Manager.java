package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Manager {

    public void calculateRun(List<Player> playerList) {
        for (Player player : playerList) {
            int randomNumber = getRandomNumber();

            if (randomNumber >= 4) {
                player.addScore();
            }
        }
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public List<Player> convertStringListToPlayerList(List<String> players) {
        return players.stream()
                .map(Player::new)
                .toList();
    }

    private List<String> convertPlayerListToStringList(List<Player> players) {
        return players.stream()
                .map(player -> player.name)
                .toList();
    }

    public List<String> getWinners(List<Player> playerList) {

        int maxScore = playerList.stream()
                .mapToInt(player -> player.score)
                .max()
                .orElse(0);

        List<Player> winners = playerList.stream()
                .filter(player -> player.score == maxScore)
                .toList();

        return convertPlayerListToStringList(winners);
    }
}
