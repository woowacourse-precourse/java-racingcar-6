package racingcar.util;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class OutputUtil {
    public static List<String> printCarInfo(List<Car> carObjects) {
        List<String> result = new ArrayList<String>();

        for (Car car : carObjects) {
            result.add(indicateCarInfo(car));
        }

        return result;
    }

    private static String indicateCarInfo(Car car) {
        StringBuilder carInfoString = new StringBuilder();

        carInfoString.append(car.getName());
        carInfoString.append(Constants.SPACE).append(Constants.COLON_SEPARATOR).append(Constants.SPACE);
        for (int i = 0; i < car.getPosition(); i++) {
            carInfoString.append(Constants.CAR_MOVEMENT_INDICATOR);
        }

        return carInfoString.toString();
    }
}
