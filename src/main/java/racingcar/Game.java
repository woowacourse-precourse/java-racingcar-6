package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Game {

    public static boolean isMovable() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    public static void moveCars(List<Car> cars) {
        for (Car car : cars) {
            if (isMovable()) {
                car.move();
            }
        }
    }

    public static void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car);
        }
        System.out.println();
    }
}
