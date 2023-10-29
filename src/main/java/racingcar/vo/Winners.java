package racingcar.vo;

import java.util.List;
import racingcar.Constants;
import racingcar.dto.WinnersDto;
import racingcar.model.Car;

public class Winners {
    private final String winners;

    public Winners(List<Car> cars) {
        StringBuilder result = new StringBuilder();

        cars.stream().map(Car::getNameValue)
                .forEach((name) -> addResult(result, name));

        trim(result);

        winners = result.toString();
    }

    private void addResult(StringBuilder result, String name) {
        result.append(Constants.WHITESPACE);
        result.append(name);
        result.append(Constants.COMMA);
    }

    private void trim(StringBuilder result) {
        result.deleteCharAt(Constants.RESULT_FIRST_INDEX);
        result.deleteCharAt(getLastIndexOfResult(result));
    }

    private int getLastIndexOfResult(StringBuilder result) {
        return result.length() - 1;
    }

    public String getWinners() {
        return winners;
    }

    public WinnersDto toDto() {
        return new WinnersDto(winners);
    }
}
