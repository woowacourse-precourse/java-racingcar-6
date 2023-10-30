package racingcar.utils;

import java.util.List;
import racingcar.domain.Car;

public class MessagePrinter {
    public static void roundResult(final List<Car> cars) {
        cars.forEach(
                car -> System.out.println(getCarName(car) + " : " + createHyphenResult(car)));
    }

    private static String getCarName(final Car car) {
        return car.getName();
    }

    private static String createHyphenResult(final Car car) {
        final int position = car.getPosition();
        return "-".repeat(position);
    }
}
