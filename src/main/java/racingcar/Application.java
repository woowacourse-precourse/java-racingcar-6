package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        List<String> carNames = inputView.getCarNames();
        List<Car> cars = new ArrayList<>();
        for (String carName: carNames) {
            cars.add(Car.create(carName));
        }

        int round = inputView.getNumberOfRound();
        for (int i = 0; i < round; ++i) {
            for (Car car: cars) {
                car.tryMove();
            }
        }
    }
}
