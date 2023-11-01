package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String[] carNames = Service.getCarNamesFromUser();
        int tryCount = Service.getTryCountFromUser();

        List<Car> cars = Service.createCars(carNames);
        Service.raceCars(cars, tryCount);
    }
}