package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class User {

    public List<String> inputCars() {
        String cars = Console.readLine();
        return Arrays.stream(cars.split(",")).toList();
    }

    public int inputAttempt() {
        return Integer.parseInt(Console.readLine());
    }
}
