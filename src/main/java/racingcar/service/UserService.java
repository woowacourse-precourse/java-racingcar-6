package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.utils.ErrorMessage;

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
            throw new IllegalArgumentException(ErrorMessage.NAMES_INPUT_IS_BLANK.getErrorMessage());
        }

        if (line.charAt(line.length() - 1) == ',') {
            throw new IllegalArgumentException(ErrorMessage.NEXT_NAMES_NOT_ENTERED.getErrorMessage());
        }
    }

    private String[] namesLineSplit(final String namesLine) {
        String[] splitNames;

        try {
            splitNames = namesLine.split(",");
        } catch (OutOfMemoryError outOfMemoryError) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_MEMORY_OF_NAMES.getErrorMessage());
        }

        return splitNames;
    }

    private void nameSizeValidation(final String name) {
        if (name.length() == 0) {
            throw new IllegalArgumentException(ErrorMessage.ENTERED_CAR_IS_BLANK.getErrorMessage());
        }

        if (name.length() > MAX_NAME_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.ENTERED_CAR_IS_TOO_LONG.getErrorMessage());
        }
    }

    private void triesValidation(final String triesInput) {
        int MAX_TRIES = Integer.MAX_VALUE;

        if (triesInput.length() > Integer.toString(MAX_TRIES).length()) {
            throw new IllegalArgumentException(ErrorMessage.TRIES_INPUT_IS_TOO_LONG.getErrorMessage());
        }

        try {
            int triesInputNumber = Integer.parseInt(triesInput);

            if (triesInputNumber < 0) {
                throw new IllegalArgumentException(ErrorMessage.TRIES_IS_NEGATIVE.getErrorMessage());
            }

        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ErrorMessage.TRIES_IS_NOT_INT.getErrorMessage());
        }
    }
}
