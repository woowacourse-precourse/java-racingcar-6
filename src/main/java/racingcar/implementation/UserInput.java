package racingcar.implementation;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class UserInput {

    public List<String> getCarList() {
        String input = Console.readLine();
        List<String> carList = ValidChecker.carListCheck(input);

        for (int i = 0; i < carList.size(); i++) {
            carList.set(i, carList.get(i).concat(" : "));
        }

        return carList;
    }

    public int getNumberOfTry() {
        int numberOfTry = 0;

        String input = Console.readLine();
        numberOfTry = ValidChecker.numberOfTryCheck(input);

        return numberOfTry;
    }
}
