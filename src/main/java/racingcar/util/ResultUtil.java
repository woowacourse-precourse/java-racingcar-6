package racingcar.util;

import java.util.List;
import racingcar.model.Car;

public class ResultUtil {
    public static String roundFormat(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        cars.forEach(car -> {
            sb.append(car.getResultFormat());
            sb.append("\n");
        });
        return sb.toString();
    }
}
