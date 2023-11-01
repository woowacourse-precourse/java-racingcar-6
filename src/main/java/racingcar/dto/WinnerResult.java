package racingcar.dto;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Winner;

public class WinnerResult {

    private final List<String> winnerResult;

    public WinnerResult(Winner winner) {
        this.winnerResult = getNames(winner.getWinners());
    }

    private List<String> getNames(List<Car> winners) {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<String> getWinners() {
        return winnerResult;
    }
}