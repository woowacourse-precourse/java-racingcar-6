package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    private List<Car> winner;

    public Winner(List<Car> winner) {
        this.winner = winner;
    }

    public boolean isSoloWinner() {
        return winner.size() == 1;
    }

    public String[] getWinnerName() {
        return winner.stream()
                .map(Car::getName)
                .toArray(String[]::new);
    }
}
