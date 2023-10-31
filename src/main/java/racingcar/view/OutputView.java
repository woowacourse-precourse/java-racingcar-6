package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    private static final String PROGRESS_MARK = "-";
    private static final String COLON = " : ";

    public void printResult(List<Car> cars) {
        cars.forEach(car -> {
            System.out.print(car.getName());
            System.out.print(COLON);
            System.out.println(PROGRESS_MARK.repeat(car.getPosition()));
        });
    }

    public void printWinner(List<String> winners) {

    }

}
