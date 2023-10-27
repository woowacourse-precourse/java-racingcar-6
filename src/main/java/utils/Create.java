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
}
