package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingService {

    public static List<Car> createCars(String carNames) {
        String[] names = carNames.split(",");
        List<Car> cars = new ArrayList<>();

        for (String name : names) {
            cars.add(new Car(name));
        }

        return cars;
    }

    public static String getCarNames() {
        return Console.readLine();
    }

    public static int getMoveCount() {
        return Integer.parseInt(Console.readLine());
    }
}
