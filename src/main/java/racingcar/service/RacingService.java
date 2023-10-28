package racingcar.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import racingcar.domain.Car;

public class RacingService {

    public static void racing(List<Car> carList, int tryNum) {
        for (int i = 0; i < tryNum; i++) {
            for (Car car : carList) {
                car.checkForward();
                System.out.println(car.getName() + " : " + car.getProgress());
            }
            System.out.println();
        }
    }

    public static List<String> findWinner(List<Car> carList) {
        int maxProgress = carList.stream().map(car -> car.getProgress().length()).max(Comparator.comparing(x -> x))
                .orElse(0);

        List<String> winnerName = new ArrayList<>();

        for (Car car : carList) {
            if (car.getProgress().length() == maxProgress) {
                winnerName.add(car.getName());
            }
        }
        return winnerName;
    }
}
