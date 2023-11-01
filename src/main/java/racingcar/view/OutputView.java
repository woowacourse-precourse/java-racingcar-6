package racingcar.view;

import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {
    private static final String GAME_RESULT = "실행 결과";
    private static final String WINNER = "최종 우승자 : ";
    private static final String DELIMITER = ",";
    private static final String SINGLE_BLANK = " ";
    private static final String COLON = ":";
    private static final String HYPHEN = "-";
    private static final String NEWLINE = "\n";

    public void printResultGuide() {
        System.out.println(GAME_RESULT);
    }

    public void printResult(Cars cars) {
        System.out.println(formatCarsResult(cars));
    }

    private String formatCarsResult(Cars cars) {
        return cars.getCars().stream()
                .map(this::formatCarResult)
                .collect(Collectors.joining(NEWLINE));
    }

    private String formatCarResult(Car car) {
        return car.getName() + SINGLE_BLANK + COLON + SINGLE_BLANK + HYPHEN.repeat(car.getPoint());
    }

    public void printWinner(Cars cars) {
        System.out.println();
        System.out.print(WINNER);
        Cars winner = cars.judgeWinner();
        System.out.println(formatWinnersResult(winner));
    }

    private String formatWinnersResult(Cars cars) {
        return cars.getCars().stream()
                .map(Car::getName)
                .collect(Collectors.joining(DELIMITER + SINGLE_BLANK));
    }
}
