package racingcar.output;

import java.util.ArrayList;
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

    public static void printRacingResult(Racing racing) {
        List<Car> winningCars = racing.getWinningCars();
        List<String> winningCarNames = new ArrayList<>();
        for (Car car : winningCars) {
            String carName = car.getName();
            winningCarNames.add(carName);
        }
        String racingResult = "최종 우승자 : " + String.join(", ", winningCarNames);
        System.out.println(racingResult);
    }
}