package racingcar.output;

import java.util.List;
import racingcar.Car;
import racingcar.constant.GuideTextConstant;

public interface Output {

    void printText(GuideTextConstant text);

    void printExecutionResult(List<Car> carList);

    void printWinner(List<Car> carList);
}
