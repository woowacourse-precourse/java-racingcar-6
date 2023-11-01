package game;

import camp.nextstep.edu.missionutils.Console;
import car.Car;
import util.GamePrinter;

import java.util.ArrayList;
import java.util.List;

public class GameInput {

    private static final int MORE_THAN_ZERO = 0;

    public List<Car> inputCarNames(String input) {
        List<Car> carList = new ArrayList<>();

        String[] carNames = input.split(",");

        for (int i = 0; i < carNames.length; i++) {
            carList.add(new Car(carNames[i]));
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
        if (Integer.parseInt(number) < MORE_THAN_ZERO){
            throw new IllegalArgumentException();
        }
    }
}
