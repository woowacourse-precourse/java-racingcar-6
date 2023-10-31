package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    public static final String GAME_START_MESSAGE = "실행 결과";
    private final String WINNER_OUTPUT_MESSAGE = "최종 우승자 : ";

    private final String DELIMITER = ", ";

    public void printGameStartMessage() {
        System.out.println("\n" + GAME_START_MESSAGE);
    }

    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            makeRoundResultMessage(car);
        }
        System.out.println();
    }

    private void makeRoundResultMessage(Car car) {
        String message = car.getName() + " : " + "-".repeat(car.getTotalMovedDistance());
        System.out.println(message);
    }

    public void printWinners(List<String> cars) {
        System.out.println(makeGameResultMessage(cars));
    }

    private String makeGameResultMessage(List<String> cars) {
        return WINNER_OUTPUT_MESSAGE + String.join(DELIMITER, cars);
    }
}
