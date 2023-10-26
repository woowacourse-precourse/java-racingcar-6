package racingcar.implementation;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class UserInput {

    public Map<String, String> getCarList() {
        Map<String, String> carMap = new HashMap<>();

        String input = Console.readLine();
        List<String> carList = ValidChecker.carListCheck(input);

        carList.forEach(car -> {
            carMap.put(car, "");
        });

        return carMap;
    }

    public int getNumberOfTry() {
        int numberOfTry = 0;

        String input = Console.readLine();
        numberOfTry = ValidChecker.numberOfTryCheck(input);

        return numberOfTry;
    }
}
