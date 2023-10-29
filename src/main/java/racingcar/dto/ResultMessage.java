package racingcar.dto;

import java.util.List;
import racingcar.Constants;
import racingcar.model.Car;

public class ResultMessage {
    private final String resultMessage;

    public ResultMessage(List<Car> cars) {
        StringBuilder result = new StringBuilder();

        cars.stream().map(Car::getNameValue)
                .forEach((name) -> addResult(result, name));

        trim(result);

        resultMessage = result.toString();
    }

    private void addResult(StringBuilder result, String name) {
        result.append(Constants.WHITESPACE);
        result.append(name);
        result.append(Constants.COMMA);
    }

    private void trim(StringBuilder result) {
        result.deleteCharAt(0);
        result.deleteCharAt(getLastIndexOfResult(result));
    }

    private int getLastIndexOfResult(StringBuilder result) {
        return result.length() - 1;
    }

    public String getResultMessage() {
        return resultMessage;
    }
}
