package racingcar.util;

import java.util.List;
import racingcar.constants.Constants;
import racingcar.dto.Winners;
import racingcar.model.Car;

public enum WinnersNameExtractor {
    INSTANCE;

    public Winners extractName(List<Car> winnersCar) {
        StringBuilder winners = new StringBuilder();

        winnersCar.stream()
                .map(Car::getNameValue)
                .forEach((name) -> addResult(winners, name));
        trim(winners);

        return toWinners(winners);
    }

    private void addResult(StringBuilder result, String name) {
        result.append(name);
        result.append(Constants.COMMA);
        result.append(Constants.WHITESPACE);
    }

    private void trim(StringBuilder result) {
        result.setLength(getRemainRangeOfResult(result));
    }

    private int getRemainRangeOfResult(StringBuilder result) {
        return result.length() - 2;
    }

    private Winners toWinners(StringBuilder winners) {
        return new Winners(toString(winners));
    }

    public String toString(StringBuilder winners) {
        return winners.toString();
    }
}