package racingcar.view;

import racingcar.model.Car;
import java.util.ArrayList;
import java.util.List;

public class GameView {
    public static void validateCarNames(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public static void printMoveStatus(Car car) {
        StringBuilder status = new StringBuilder(car.getName() + " : ");
        for (int i = 0; i < car.getMoveStatus(); i++) {
            status.append("-");
        }
        System.out.println(status);
    }

    public static List<Car> checkWinners(List<Car> cars) {
        List<Car> carsWithMaxMoveStatus = new ArrayList<>();
        int maxMoveStatus = Integer.MIN_VALUE;
        for (Car car : cars) {
            int moveStatus = car.getMoveStatus();
            if (moveStatus > maxMoveStatus) {
                maxMoveStatus = moveStatus;
                carsWithMaxMoveStatus.clear();
                carsWithMaxMoveStatus.add(car);
            } else if (moveStatus == maxMoveStatus) {
                carsWithMaxMoveStatus.add(car);
            }
        }
        return carsWithMaxMoveStatus;
    }

    public static void printWinnerCars(List<Car> winnerCars) {
        StringBuilder winnerCarsOutput = new StringBuilder("최종 우승자 : ");
        for (int i = 0; i < winnerCars.size(); i++) {
            if (i > 0) {
                winnerCarsOutput.append(", ");
            }
            winnerCarsOutput.append(winnerCars.get(i).getName());
        }
        System.out.println(winnerCarsOutput);
    }
}
