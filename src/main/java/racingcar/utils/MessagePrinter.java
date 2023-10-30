package racingcar.utils;

import static racingcar.Application.createHyphenResult;

import java.util.List;
import racingcar.domain.Car;

public class MessagePrinter {
    public static void printRoundResult(final List<Car> cars) {
        cars.forEach(
                car -> System.out.println(getCarName(car) + " : " + createHyphenResult(car)));
    }

    private static String getCarName(final Car car) {
        return car.getName();
    }
}
