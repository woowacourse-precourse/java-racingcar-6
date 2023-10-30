package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
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

    public List<Player> stringListToPlayerList(List<String> players) {
        List<Player> playerList = new ArrayList<>();
        for (String name : players) {
            Player player = new Player(name);
            playerList.add(player);
        }
        return playerList;
    }

    public List<Player> getWinners(List<Player> playerList) {
        int maxScore = 0;
        List<Player> winners = new ArrayList<>();
        for (Player player : playerList) {
            if (player.score > maxScore) {
                maxScore = player.score;
            }
        }

        for (Player player : playerList) {
            if (player.score == maxScore) {
                winners.add(player);
            }
        }

        return winners;
    }

//    private Map<Player, Integer> playerListToMap(List<String> playerList){
//        Map<Player, Integer> playerMap = new HashMap<>();
//        for(String name : playerList) {
//            Player player = new Player(name);
//            playerMap.put(player, 0);
//        }
//
//        return playerMap;
//    }


}
