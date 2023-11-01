package racingcar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;

public class RacingWinner {
    RacingGame racingGame = new RacingGame();

    LinkedHashMap<String, Integer> cars = racingGame.cars;

    ArrayList<String> winners = new ArrayList<>();

    public Integer maxNumberWinner () {
        racingGame.tryNumberRacing();
        return cars.values().stream().max(Comparator.comparingInt(n -> n)).get();
    }

    public void findWinner () {
        Integer maxNumber = maxNumberWinner();
        racingGame.cars.entrySet().stream().filter(e -> maxNumber.equals(e.getValue())).forEach((e->winners.add(e.getKey())));

    }

    public void printWinner () {
        findWinner();
        String strWinners = String.join(",", winners);
        System.out.println(MessageUtil.Winners_Message + " : " + strWinners);

    }
}
