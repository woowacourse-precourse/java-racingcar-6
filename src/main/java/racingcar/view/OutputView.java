package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

import java.util.List;

public final class OutputView {

    public static final OutputView OUTPUT_VIEW = new OutputView();
    public final String GAME_START_MESSAGE = "실행 결과";
    private final String WINNER_OUTPUT_MESSAGE = "최종 우승자 : ";
    private final String DELIMITER = ", ";

    private OutputView() {

    }

    public void printGameStartMessage() {
        System.out.println("\n" + GAME_START_MESSAGE);
    }

    public void printRoundResult(Cars cars) {
        List<Car> raceCars = cars.getCars();
        raceCars.forEach(this::makeRoundResultMessage);
        System.out.println();
    }

    public void printWinners(List<String> cars) {
        System.out.println(makeGameResultMessage(cars));
    }

    private void makeRoundResultMessage(Car car) {
        String message = car.getName() + " : " + "-".repeat(car.getTotalMovedDistance());
        System.out.println(message);
    }

    private String makeGameResultMessage(List<String> cars) {
        return WINNER_OUTPUT_MESSAGE + String.join(DELIMITER, cars);
    }
}
