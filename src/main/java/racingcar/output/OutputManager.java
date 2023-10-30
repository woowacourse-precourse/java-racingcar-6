package racingcar.output;

import java.util.List;
import racingcar.game.Car;
import racingcar.game.Racing;

public class OutputManager {
    public static void printRacingStatus(Racing racing) {
        List<Car> racingCars = racing.getRacingCars();
        for (Car car : racingCars) {
            String carName = car.getName();
            String carRoute = car.getRoute();
            System.out.printf("%s : %s\n", carName, carRoute);
        }
        System.out.println();
    }
}