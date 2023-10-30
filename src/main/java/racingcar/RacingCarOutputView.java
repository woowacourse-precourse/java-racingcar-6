package racingcar;

import java.util.List;

public class RacingCarOutputView {
    public void moveResultPrint(Integer iterNumber, List<Car> cars) {
        for (int i = 0; i < iterNumber; i++) {
            for (int j = 0; j < cars.size(); j++) {
                Car car = cars.get(j);
                car.moveOrStop();
                System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
            }
            System.out.println();
        }
    }
}
