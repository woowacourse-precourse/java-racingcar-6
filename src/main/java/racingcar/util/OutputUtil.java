package racingcar.util;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class OutputUtil {
    public static String getCurrentProgress(List<Car> carObjects) {
        StringBuilder result = new StringBuilder();

        for (Car car : carObjects) {
            result.append(indicateCarInfo(car)).append(Constants.NEW_LINE);
        }

        return result.toString();
    }

    private static String indicateCarInfo(Car car) {
        StringBuilder carInfoString = new StringBuilder();

        carInfoString.append(car.getName());
        carInfoString.append(Constants.SPACE).append(Constants.COLON_SEPARATOR).append(Constants.SPACE);
        carInfoString.append(Constants.CAR_MOVEMENT_INDICATOR.repeat(Math.max(0, car.getPosition())));

        return carInfoString.toString();
    }
}
