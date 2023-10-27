package racingcar.output;

import java.util.List;
import racingcar.Car;

public interface Output {

    void printText(String text);

    void printExecutionResult(List<Car> carList);

    void printWinner(List<Car> carList);
}
