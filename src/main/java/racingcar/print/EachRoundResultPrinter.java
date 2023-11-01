package racingcar.print;

import java.util.List;
import racingcar.car.Car;

public abstract class EachRoundResultPrinter {
    private static final StringBuilder eachRoundResult = new StringBuilder();

    private EachRoundResultPrinter() {
    }

    public static void printEachRoundResult(List<Car> racingCarList) {
        for (Car car : racingCarList) {
            eachRoundResult.append(car.getCarName()).append(" : ");
            eachRoundResult.append("-".repeat(Math.max(0, car.getCurrentPosition())));
            eachRoundResult.append("\n");
        }
        System.out.println(eachRoundResult.toString());
    }
}
