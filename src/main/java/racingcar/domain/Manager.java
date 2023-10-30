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
