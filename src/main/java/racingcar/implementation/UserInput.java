package racingcar.implementation;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class UserInput {

    private Map<String, String> carMap = new HashMap<>();
    private int numberOfTry = 0;

    public Map<String, String> getCarList() {
        String input = Console.readLine();
        List<String> carList = ValidChecker.carListCheck(input);

        carList.forEach(car -> {
            carMap.put(car, "");
        });

        return carMap;
    }

    public int getNumberOfTry() {
        String input = Console.readLine();
        numberOfTry = ValidChecker.numberOfTryCheck(input);

        return numberOfTry;
    }
}
