package racingcar.view;

import domain.valueObject.Car;

import java.util.List;

public class OutputView {
    private static final String WINNERS_DELIMITER = ", ";
    private static final String MESSAGE_WINNER_ANNOUNCE = "최종 우승자 : %s";
    private static final String RACE_PROGRESS_CHARACTER = "-";
    private static final int ZERO = 0;

    private OutputView() {
    }

    public static void printCurrentPosition(final List<Car> cars) {
        cars.forEach(OutputView::printCurrentPosition);
        System.out.println();
    }

    private static void printCurrentPosition(final Car car) {
        System.out.printf("%s : %s%n", car.getName(), getPositionString(car.getPosition()));
    }

    private static Object getPositionString(final int position) {
        return RACE_PROGRESS_CHARACTER.repeat(Math.max(ZERO, position));
    }

    public static void printWinner(final List<String> winner) {
        System.out.printf(MESSAGE_WINNER_ANNOUNCE, String.join(WINNERS_DELIMITER, winner));
    }
}
