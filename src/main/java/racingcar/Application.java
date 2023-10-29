package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Car> carList = CarFactory.createCars(UserInput.getCarNames());
        int attemptsNumber = UserInput.getAttemptsNumber();

        Race.start(carList, attemptsNumber);
    }
}
