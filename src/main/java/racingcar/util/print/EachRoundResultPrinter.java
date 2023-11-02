package racingcar.util.print;

import java.util.List;
import racingcar.car.Car;

public abstract class EachRoundResultPrinter {

    private EachRoundResultPrinter() {
    }

    public static void printEachRoundResult(List<Car> racingCarList) {
        StringBuilder eachRoundResult = new StringBuilder();
        for (Car car : racingCarList) {
            eachRoundResult.append(car.getCarName()).append(" : ");
            eachRoundResult.append("-".repeat(Math.max(0, car.getCurrentPosition())));
            eachRoundResult.append("\n");
        }
        System.out.println(eachRoundResult);

    }
}
