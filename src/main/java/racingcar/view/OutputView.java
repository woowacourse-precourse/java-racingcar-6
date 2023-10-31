package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    private static final String PROGRESS_MARK = "-";
    private static final String COLON = " : ";
    private static final String DELIMITER = ", ";
    private static final String WINNER_MESSAGE = "최종 우승자";

    public void printResult(List<Car> cars) {
        cars.forEach(car -> {
            System.out.print(car.getName());
            System.out.print(COLON);
            System.out.println(PROGRESS_MARK.repeat(car.getPosition()));
        });
    }

    public void printWinner(List<String> winners) {
        System.out.print(WINNER_MESSAGE + COLON);
        System.out.println(String.join(DELIMITER, winners));
    }

}
