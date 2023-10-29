package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {
    private static final String EACH_FORWARD_INFORMATION = "-";
    private static final String INPUT_CAR_NAMES_INFO = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_MOVEMENT_TIME_INFO = "시도할 회수는 몇회인가요?";

    public void printCarNamesInput() {
        System.out.println(INPUT_CAR_NAMES_INFO);
    }

    public void printMovementInfoInput() {
        System.out.println(INPUT_MOVEMENT_TIME_INFO);
    }

    public void printExecutionResultsOrder(List<Car> cars) {
        StringBuilder executionResult = new StringBuilder();
        for (Car car : cars) {
            printForwardInfo(car, executionResult);
        }
        System.out.println(executionResult);
    }

    private void printForwardInfo(Car car, StringBuilder executionResult) {
        executionResult.append(
                        String.format("%s : %s", car.getName(), EACH_FORWARD_INFORMATION.repeat(car.getForwards())))
                .append('\n');
    }
}
