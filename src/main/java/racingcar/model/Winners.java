package racingcar.model;

import java.util.List;
import racingcar.constants.Constants;

public class Winners {
    private final String winners;

    public Winners(List<Car> winnersCar) {
        winners = createWinner(winnersCar);
    }

    private String createWinner(List<Car> winnersCar) {
        StringBuilder winners = new StringBuilder();

        winnersCar.stream().map(Car::getNameValue)
                .forEach((name) -> addResult(winners, name));

        trim(winners);

        return toString(winners);
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

    private String toString(StringBuilder winners) {
        return winners.toString();
    }

    public String getWinners() {
        return winners;
    }
}
