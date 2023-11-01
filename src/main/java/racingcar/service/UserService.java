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
        String namesInputLine = Console.readLine();
        namesLineValidation(namesInputLine);
        String[] names = namesLineSplit(namesInputLine);

        List<Car> cars = getCarsList(names);
        return cars;
    }

    public int getTries() {
        String triesInputLine = Console.readLine();
        triesValidation(triesInputLine);

        int tries = Integer.parseInt(triesInputLine);
        return tries;
    }

    private List<Car> getCarsList(final String[] names) {
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            nameSizeValidation(name);

            cars.add(new Car(name));
        }

        return cars;
    }

    private void namesLineValidation(final String line) {
        if (line.length() == 0) {
            throw new IllegalArgumentException("Input car names are not exist!");
        }

        if (line.charAt(line.length() - 1) == ',') {
            throw new IllegalArgumentException("Next car names is not entered!");
        }
    }

    private String[] namesLineSplit(final String namesLine) {
        String[] splitNames;

        try {
            splitNames = namesLine.split(",");
        } catch (OutOfMemoryError outOfMemoryError) {
            throw new IllegalArgumentException("Input car names is too large in this system!");
        }

        return splitNames;
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
                throw new IllegalArgumentException("Tries Input is not a suitable value!");
            }

        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("Tries Input is not a Integer number!");
        }
    }
}
