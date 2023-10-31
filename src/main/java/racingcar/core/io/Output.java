package racingcar.core.io;

import racingcar.domain.Car;

import java.util.List;

import static racingcar.constant.OutputConstant.FINAL_STEP_RESULT;
import static racingcar.constant.OutputConstant.ONE_STEP_RESULT;

public class Output {
    public void printResult(List<Car> cars) {
        System.out.println(ONE_STEP_RESULT);
        for (Car car : cars) {
            System.out.print(car.getName() +" : ");
            System.out.print("-".repeat(car.getCurrentStep()));
            System.out.println();
        }
    }
    public void printWinner(List<String> cars) {
        System.out.print(FINAL_STEP_RESULT);

        String result = String.join(",", cars);
        System.out.print(result);
    }
}
