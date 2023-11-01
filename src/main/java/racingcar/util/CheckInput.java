package racingcar.util;

import java.util.*;

public class CheckInput {
    public static List<String> check(String nameOfCars) {
        List<String> players = List.of(nameOfCars.split(","));

        for (String player : players) {
            if (player.length() > 4)
                throw new IllegalArgumentException();
        }
        return players;
    }
}