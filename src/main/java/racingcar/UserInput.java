package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UserInput {
    Verification verification = new Verification();

    private List<String> carNames;
    private int numberOfTry;
    public void labelNameOfCar() {
        String readLine = Console.readLine();
        carNames = List.of(readLine.split(","));
        verification.verifyArg(carNames);
    }

    public void setupNumberOfTry() {
        String readLine = Console.readLine();
        verification.verifyNumberOfTry(readLine);
        numberOfTry = Integer.valueOf(readLine);
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getNumberOfTry() {
        return numberOfTry;
    }
}
