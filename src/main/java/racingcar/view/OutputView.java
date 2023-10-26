package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.service.Referee;

public class OutputView {

    private static final String DELIMITER = " : ";

    public void showResultMessage() {
        System.out.println("실행 결과");
    }

    public void showResult(List<Car> cars) {
        for (Car car : cars) {
            StringBuilder stringBuilder = new StringBuilder();
            System.out.println(car.getCarName() + DELIMITER + car.getPosition().countPositionToString(stringBuilder));
        }
        System.out.println();
    }

    public void showWinner(Referee referee, Cars cars) {
        System.out.println("최종 우승자" + DELIMITER + referee.getWinner(cars));
    }
}
