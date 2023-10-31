package racingcar.implementation;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class UserInput {
    public Scanner sc = new Scanner(System.in);
    private ValidChecker checker;

    public UserInput() {
        checker = new ValidChecker();
    }

    public List<String> getCarList() {
        String input = sc.next();
        List<String> carList = checker.carListCheck(input.replace(" ",""));

        for (int i = 0; i < carList.size(); i++) {
            carList.set(i, carList.get(i).concat(" : "));
        }

        return carList;
    }

    public int getNumberOfTry() {
        int numberOfTry = 0;

        String input = sc.next();
        numberOfTry = checker.numberOfTryCheck(input);

        return numberOfTry;
    }
}
