package racingcar;

import java.util.List;
import racingcar.car.Car;

public class StaticRacingCar {
    static class User {
        public static String[] carNames() {
            return new String[]{"A", "B", "C"};
        }

        public static String racingRound() {
            return "3";
        }
    }

    static class NumberGenerator {
        public static int generateNumber() {
            return 4;
        }

    }
    static String eachRoundResult(List<Car> racingCarList) {
        StringBuilder result = new StringBuilder();

        for (Car car : racingCarList) {
            result.append(car.getCarName()).append(" : ");
            result.append("-".repeat(Math.max(0, car.getCurrentPosition())));
            result.append("\n");
        }
        return result.toString();
    }

}
