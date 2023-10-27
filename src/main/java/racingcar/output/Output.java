package racingcar.output;

import java.util.List;
import racingcar.Car;

public interface Output {

    void printGuideTextForCarNames();

    void printGuideTextForExecutionCount();

    void printExecutionResult(List<Car> carList);

    void printWinner(List<Car> carList);
}
