package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();

        List<String> carNames = inputView.getCarNames();
        int numberOfMoves = inputView.getNumberOfMoves();

        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {

            cars.add(new Car(carName));

        }

        for (int i = 0; i < numberOfMoves; i++) {

            for (Car car : cars) {

                car.determineCarState();

            }

            inputView.printRaceResult(cars);
        }
    }
}
