package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final int MAX_NAME_SIZE = 5;
    private static UserService INSTANCE;

    private UserService() {
    }

    public static UserService getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new UserService();
        }

        return INSTANCE;
    }

    public List<Car> getCars() {
        String[] names;
        try {
            names = Console.readLine().split(",");
        } catch (OutOfMemoryError outOfMemoryError) {
            throw new IllegalArgumentException("Input car names is too large in this system!");
        }

        List<Car> cars = new ArrayList<Car>();
        for (String name : names) {
            nameSizeValidation(name);

            cars.add(new Car(name));
        }

        return cars;
    }

    public int getTries() {
        String triesInput = Console.readLine();
        triesValidation(triesInput);

        int tries = Integer.parseInt(triesInput);
        return tries;
    }

    private void nameSizeValidation(final String name) {
        if (name.length() == 0) {
            throw new IllegalArgumentException("Car name is not entered!");
        }

        if (name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException("Car name is longer than 5!");
        }
    }

    private void triesValidation(final String triesInput) {
        int MAX_TRIES = Integer.MAX_VALUE;

        if (triesInput.length() > Integer.toString(MAX_TRIES).length()) {
            throw new IllegalArgumentException("Tries Input is too long!");
        }

        try {
            int triesInputNumber = Integer.parseInt(triesInput);

            if (triesInputNumber < 0) {
                throw new IllegalArgumentException("Tries Input must not be less than 0!");
            }

        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("Tries Input is not a Integer number!");
        }
    }
}
