package racingcar.io;

import racingcar.domain.Car;

import java.util.List;

public class OutputProcessor {
    private static final String ROAD = "-";

    private OutputProcessor() {
    }

    public static void printRacingRound(final List<Car> cars) {
        for (final Car car : cars) {
            System.out.printf(
                    "%s : %s\n",
                    car.getName().getValue(),
                    formattingPosition(car.getPosition().getValue())
            );
        }
    }

    private static String formattingPosition(final int position) {
        return ROAD.repeat(position);
    }
}
