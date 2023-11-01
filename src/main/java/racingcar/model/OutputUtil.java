package racingcar.model;

import java.util.ArrayList;
import java.util.List;

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

        carInfoString.append(car.getName()).append(" : ");
        for (int i = 0; i < car.getPosition(); i++) {
            carInfoString.append("-");
        }

        return carInfoString.toString();
    }
}
