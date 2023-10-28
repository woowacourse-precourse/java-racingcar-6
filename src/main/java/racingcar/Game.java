package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
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

    public static void printWinners(List<Car> cars) {
        Car winner = Collections.max(cars);
        int maxPosition = winner.getPosition();

        List<String> winnerNames = cars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .map(Car::getName)
            .toList();

        System.out.println("최종 우승자 : " + String.join(", ", winnerNames));
    }
}
