package racingcar.service;

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
}
