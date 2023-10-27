package racingcar.output;

import java.util.List;
import racingcar.Car;

public class ConsoleOutput implements Output {

    @Override
    public void printText(String text) {
        System.out.println(text);
    }

    @Override
    public void printExecutionResult(List<Car> carList) {
        carList.forEach(car -> System.out.println(car.getName() + " : " + "-".repeat(car.getDistance())));
        System.out.println();
    }

    @Override
    public void printWinner(List<Car> carList) {

    }
}
