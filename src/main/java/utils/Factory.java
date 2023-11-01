package utils;

import camp.nextstep.edu.missionutils.Randoms;
import player.Player;

import java.util.*;

public class Factory {
    public static int createRandomDigit() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static List<Player> createPlayersArray(List<String> playersName) {
        List<Player> playersArray = new ArrayList<>();
        for (String playerName : playersName) {
            Player player = new Player(playerName);
            playersArray.add(player);
        }
        return playersArray;
    }

    public static Map<String, Integer> createPlayerDistanceMap(List<Player> playersArray) {
        // HashMap의 입력 순서를 보장하기 위해서 LinkedHashMap 사용
        Map<String, Integer> playerDistanceMap = new LinkedHashMap<>();
        for (Player player : playersArray) {
            playerDistanceMap.put(player.getPlayerName(), player.getDistance());
        }
        return playerDistanceMap;
    }
}
