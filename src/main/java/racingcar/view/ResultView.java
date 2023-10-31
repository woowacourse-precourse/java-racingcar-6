package racingcar.view;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import racingcar.car.Car;

public class ResultView {
    private ResultView() {
    }

    private static final String RESULT_COVER_MESSAGE = "실행 결과";
    private static final String MOVE_SYMBOL = "-";
    private static final String WORD_SEPARATOR = " : ";
    private static final String WINNER_TAG_MESSAGE = "최종 우승자";
    private static final String NAME_SEPARATOR = ",";

    public static void printResultCoverMessage() {
        System.out.println(RESULT_COVER_MESSAGE);
    }

    public static void printMoveResultMessage(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(createMoveMessage(car));
        }
    }

    private static String createMoveMessage(Car car) {
        return car.getName() + WORD_SEPARATOR + MOVE_SYMBOL.repeat(car.getMoveCount());
    }

    public static void printWinnerMessage(List<Car> cars) {
        System.out.println(createWinnerMessage(cars));
    }

    private static String createWinnerMessage(List<Car> cars) {
        return WINNER_TAG_MESSAGE + WORD_SEPARATOR + getWinnerMessage(cars);
    }

    private static String getWinnerMessage(List<Car> cars) {
        Comparator<Car> comparatorByMoveCount = Comparator.comparingInt(Car::getMoveCount);
        int maxMoveCount = cars.stream()
                .max(comparatorByMoveCount)
                .orElseThrow(NoSuchElementException::new)
                .getMoveCount();

        return cars.stream()
                .filter(car -> car.getMoveCount() == maxMoveCount)
                .map(Car::getName)
                .collect(Collectors.joining(NAME_SEPARATOR));
    }
}
