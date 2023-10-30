package racingcar.view;

import static racingcar.utility.Constants.*;

import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarStorage;

public class UserView {
    public UserView() {}
    public void printInputNameMessage() {
        System.out.println(INPUT_CAR_NAME);
    }
    public void printInputCountMessage() {
        System.out.println(INPUT_TRY_COUNT);
    }
    public void printResultMessage() {
        System.out.println(RESULT);
    }
    public void printCurrentResult() {
        CarStorage carStorage = new CarStorage();
        List<Car> cars = carStorage.cars();
        for (Car car: cars) {
            System.out.println(car.name() + COLON + LINE.repeat(car.steps()));
        }
        System.out.println();
    }
    public void printWinners() {
        CarStorage carStorage = new CarStorage();
        List<Car> winners = carStorage.winners();
        System.out.print(WINNERS + COLON);
        for (Car winner: winners) {
            System.out.print(winner.name());
            if (winners.indexOf(winner) != winners.size() - 1) { // 마지막 원소라면 콤마를 출력하지 않음
                System.out.print(COMMA + " ");
            }
        }
        System.out.println();
    }
}
