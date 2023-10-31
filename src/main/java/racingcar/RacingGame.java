package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final Print print = new Print();
    private final Util util = new Util();

    public void race(List<Car> cars, int times) {
        System.out.println("\n실행 결과");
        for (int i = 0; i < times; i++) {
            for (Car car : cars) {
                int num = util.getRandomNum();
                forwardOrStop(car, num);
            }
            print.showResult(cars);
        }
    }

    void forwardOrStop(Car car, int num) {
        if (num >= 4) {
            car.forward();
        }
    }

    public List<String> getMaxMoveCar(List<Car> cars) {
        int max = 0;
        List<String> maxMoveCarName = new ArrayList<>();

        for (Car car : cars) {
            if (car.getMove() < max) {
                continue;
            }
            if (car.getMove() > max) {
                maxMoveCarName.clear();
                max = car.getMove();
            }
            maxMoveCarName.add(car.getName());
        }
        return maxMoveCarName;
    }
}
