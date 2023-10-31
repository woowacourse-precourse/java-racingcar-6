package racingcar.domain.game;

import racingcar.domain.car.Car;

import java.util.ArrayList;
import java.util.List;

public class ExecutionResultGenerator {
    private static final String NEW_LINE = "\n";
    private static final String MOVE_MARK = "-";
    private List<String> executionResults;

    public ExecutionResultGenerator() {
        this.executionResults = new ArrayList<>();
    }

    public String generateAllExecutionResults() {
        StringBuilder totalResults = new StringBuilder();
        for (String s : executionResults) {
            totalResults.append(s).append(NEW_LINE);
        }
        return totalResults.toString();
    }

    public void generateOneTurnExecutionResults(List<Car> cars) {
        StringBuilder oneTurnResults = new StringBuilder();
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);

            String result = generateExecutionResult(car);
            oneTurnResults.append(result).append(NEW_LINE);
        }
        executionResults.add(oneTurnResults.toString());
    }

    public String generateExecutionResult(Car car) {
        String prefix = String.format("%s : ", car.getName());
        StringBuilder moveRange = new StringBuilder(prefix);
        for (int i = 0; i < car.getMoveCount(); i++) {
            moveRange.append(MOVE_MARK);
        }
        return moveRange.toString();
    }

    public List<String> getExecutionResults() {
        return executionResults;
    }
}
