package racingcar;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

    public void printRound(List<Car> cars) {
        for (Car car : cars) {
            car.printResult();
        }
        System.out.println();
    }

    public String getWinner(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int maxMovingCnt = getMaxMovingCnt(cars);
        for (Car car : cars) {
            if (car.getMovingCnt() == maxMovingCnt) {
                winners.add(car.getName());
            }
        }
        return String.join(",", winners);

    }

    public int getMaxMovingCnt(List<Car> cars) {
        return cars.stream()
                .max(Car::compareTo)
                .get().getMovingCnt();
    }
}
