package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class User {

    public List<String> inputCars() {
        String cars = Console.readLine();
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("Empty input car name");
        }
        return Arrays.stream(cars.split(",")).toList();
    }

    public int inputAttempt() {
        try {
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException("Wrong input attempt", e);
        }
    }
}
