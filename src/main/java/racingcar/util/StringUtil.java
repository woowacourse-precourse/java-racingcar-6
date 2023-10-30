package racingcar.util;

import java.util.List;
import racingcar.model.Car;

public class StringUtil {
    public static List<String> convertStringToList(String input) {
        return List.of(input.split(","));
    }

    public static StringBuilder convertListToString(List<Car> carList) {
        StringBuilder result = new StringBuilder();
        for(Car car : carList) {
            result.append(car.getName()).append(", ");
        }
        result.setLength(result.length() - 2);
        return result;
    }

    public static int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }
}
