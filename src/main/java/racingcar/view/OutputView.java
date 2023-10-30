package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    private static final String POSITION_SEPERATOR = "-";
    private static final String OUTPUT_RESULT_MESSAGE = "실행 결과";
    private static final String OUTPUT_RESULT_FORMAT = "%s : %s\n";
    private static final String OUTPUT_WINNERS = "최종 우승자 : %s";

    private OutputView() {
    }

    public void printResultMessage() {
        System.out.println(OUTPUT_RESULT_MESSAGE);
    }

    private String printCarPositionResult(Car car) {
        return POSITION_SEPERATOR.repeat(car.getPosition());
    }

    public void printCarResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.printf(OUTPUT_RESULT_FORMAT, car.getName(), printCarPositionResult(car));
        }
    }

    public void printWinners(List<String> winnerList) {
        System.out.printf(OUTPUT_WINNERS, String.join(", ", winnerList));
    }
}
