package utils;

import camp.nextstep.edu.missionutils.Randoms;
import player.Player;

import java.util.*;

public class Create {
    public static int randomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static List<Player> playerObjectArray(List<String> players) {
        List<Player> playerObjectArray = new ArrayList<>();
        for (String player : players) {
            Player car = new Player(player);
            playerObjectArray.add(car);
        }
        return playerObjectArray;
    }

    public static Map<String, Integer> playerDistanceMapping(List<Player> playerObjectArray){
        // HashMap의 입력 순서를 보장하기 위해서 LinkedHashMap 사용
        Map<String, Integer> playerDistanceMap = new LinkedHashMap<>();
        for (Player car : playerObjectArray) {
            playerDistanceMap.put(car.getPlayerName(), car.getDist());
        }
        return playerDistanceMap;
    }
}
