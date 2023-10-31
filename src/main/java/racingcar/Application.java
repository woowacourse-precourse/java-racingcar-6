package racingcar;

import java.util.List;
import racingcar.domain.CarRacing;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        List<String> cars = InputView.inputCars();
        int turn = InputView.inputTurn();

        CarRacing carRacing = new CarRacing(cars);
        carRacing.race(turn);
    }
}
