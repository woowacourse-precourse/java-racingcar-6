package racingcar.service;

import java.util.Comparator;
import java.util.List;
import racingcar.domain.Car;

public class RacingService {

    public static void racing(List<Car> carList, int tryNum) {
        for (int i = 0; i < tryNum; i++) {

            for (Car car : carList) {
                car.forward();
                System.out.println(car.getName() + " : " + car.getProgress());
            }

            System.out.println();
        }
    }

    public static void findWinner(List<Car> carList, List<String> winnerName) {
        int maxProgress = findMaxProgressInCarList(carList);

        for (Car car : carList) {
            if (car.getProgress().length() == maxProgress) {
                winnerName.add(car.getName());
            }
        }
    }

    private static Integer findMaxProgressInCarList(List<Car> carList) {
        return carList.stream().map(car -> car.getProgress().length()).max(Comparator.comparing(x -> x))
                .orElse(0);
    }
}
