package racingcar.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ScoreBoardGenerator {
    protected static Set<String> nameSet = new HashSet<>();

    public ScoreBoardGenerator () {
    }

    public static ArrayList<Car> initScoreBoard (String[] nameList) {
        ArrayList<Car> board = new ArrayList<>();

        for (String carName : nameList) {
            if (nameSet.contains(carName)) {
                board.add(new Car(existSameName(carName), BigInteger.ZERO));
            } else {
                board.add(new Car(carName, BigInteger.ZERO));
                nameSet.add(carName);
            }
        }

        return board;
    }

    private static String existSameName (String carName) {
        int i = 2;
        String orderName = carName + "_" + i;

        while (nameSet.contains(orderName)) {
            i ++;
            orderName = carName + "_" + i;
        }

        nameSet.add(orderName);
        return orderName;
    }
}