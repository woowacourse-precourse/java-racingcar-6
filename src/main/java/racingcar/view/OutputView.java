package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    private static final String PROGRESS_MARK = "-";
    private static final String COLON = " : ";
    private static final String DELIMITER = ", ";
    private static final String WINNER_MESSAGE = "최종 우승자";
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String LINE_BREAK = System.lineSeparator();


    public void printResult(List<Car> cars) {
        cars.forEach(car -> {
            System.out.print(car.getName());
            System.out.print(COLON);
            System.out.println(PROGRESS_MARK.repeat(car.getPosition()));
        });
        System.out.print(LINE_BREAK);
    }

    public void printWinner(List<String> winners) {
        System.out.print(WINNER_MESSAGE + COLON);
        System.out.println(String.join(DELIMITER, winners));
    }

    public void printResultMessage() {
        System.out.println(LINE_BREAK + RESULT_MESSAGE);
    }

}
