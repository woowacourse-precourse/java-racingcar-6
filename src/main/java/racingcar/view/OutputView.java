package racingcar.view;

import java.util.List;
import racingcar.constant.RaceInfoMessage;
import racingcar.model.Car;

public class OutputView {
    public void printCarNamesInput() {
        System.out.println(RaceInfoMessage.INPUT_CAR_NAMES_INFO.getMessage());
    }

    public void printMovementInfoInput() {
        System.out.println(RaceInfoMessage.INPUT_MOVEMENT_TIME_INFO.getMessage());
    }

    public void printExecutionResultsInfo() {
        System.out.println(RaceInfoMessage.EXECUTION_RESULTS_INFO.getMessage());
    }

    public void printExecutionResultsOrder(List<Car> cars) {
        StringBuilder executionResult = new StringBuilder();
        for (Car car : cars) {
            printForwardInfo(car, executionResult);
        }
        System.out.println(executionResult);
    }

    public void printFinalWinners(List<String> finalWinners) {
        StringBuilder winners = new StringBuilder(RaceInfoMessage.FINAL_WINNER_INFO.getMessage());
        winners.append(finalWinners.toString().substring(1, finalWinners.toString().length() - 1));
        System.out.println(winners);
    }

    private void printForwardInfo(Car car, StringBuilder executionResult) {
        executionResult.append(
                        String.format("%s : %s", car.getName(), RaceInfoMessage.EACH_FORWARD_INFORMATION.getMessage().repeat(car.getForwards())))
                .append('\n');
    }
}
