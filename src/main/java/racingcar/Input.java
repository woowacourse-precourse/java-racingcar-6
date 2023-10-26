package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    String cars;
    int numberOfAttempt;

    public void inputCars() {
        cars = Console.readLine();
    }

    public void inputNumberOfAttempt() {
        numberOfAttempt = Integer.parseInt(Console.readLine());
    }

    public String getInputCars() {
        return cars;
    }
}