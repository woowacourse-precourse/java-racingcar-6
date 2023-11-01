package racingcar;

import java.util.List;
import racingcar.domain.CarRacing;
import racingcar.domain.RandomNumber;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        List<String> cars = InputView.inputCars();
        int turn = InputView.inputTurn();

        CarRacing carRacing = new CarRacing(cars, new RandomNumber());
        carRacing.race(turn);
    }
}
