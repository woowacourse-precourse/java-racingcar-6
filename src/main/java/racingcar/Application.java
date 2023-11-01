package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Racing racing = createRacing(inputView);
        racing.race();
    }

    private static Racing createRacing(InputView inputView) {
        List<Car> cars = createCars(inputView);
        int roundNumber = inputView.askRoundNumber();
        return new Racing(cars, roundNumber);
    }

    private static List<Car> createCars(InputView inputView) {
        List<String> carNames = inputView.askCarNames();
        return createCars(carNames);
    }

    private static List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }
}
