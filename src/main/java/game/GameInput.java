package game;

import car.Car;

import java.util.ArrayList;
import java.util.List;

public class GameInput {

    private static final int MORE_THAN_ZERO = 0;
    private static final String COMMA = ",";


    public List<Car> inputCarNames(String input) {
        List<Car> carList = new ArrayList<>();

        String[] carNames = input.split(COMMA,-1);

        for (int i = 0; i < carNames.length; i++) {
            String carName = carNames[i].trim();
            validateNameBlank(carName);
            carList.add(new Car(carName));
        }

        return carList;
    }

    public int inputCount(String count) {
        validateNumberFormat(count);
        validateNumberRange(count);

        return Integer.parseInt(count);
    }

    private void validateNumberFormat(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberRange(String number) {
        if (Integer.parseInt(number) < MORE_THAN_ZERO) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNameBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException();
        }
    }
}
