package racingcar.io;

import racingcar.domain.Car;

import java.util.List;

import static java.util.stream.Collectors.joining;

public class OutputProcessor {
    private static final String ROUND_RESULT_FORMAT = "%s : %s\n";
    private static final String WINNER_RESULT_FORMAT = "최종 우승자 : %s\n";
    private static final String ROAD = "-";
    private static final String DELIMITER = ", ";

    private OutputProcessor() {
    }

    public static void printRacingRound(final List<Car> cars) {
        for (final Car car : cars) {
            System.out.printf(
                    ROUND_RESULT_FORMAT,
                    car.getName().getValue(),
                    formattingPosition(car.getPosition().getValue())
            );
        }
    }

    private static String formattingPosition(final int position) {
        return ROAD.repeat(position);
    }

    public static void printWinners(final List<Car> winners) {
        System.out.printf(WINNER_RESULT_FORMAT, formattingWinners(winners));
    }

    private static String formattingWinners(final List<Car> winners) {
        return winners.stream()
                .map(winner -> winner.getName().getValue())
                .collect(joining(DELIMITER));
    }
}
