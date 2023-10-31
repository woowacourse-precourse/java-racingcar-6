package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class GameResult {
    private List<Car> winners;

    private GameResult(List<Car> winners) {
        this.winners = winners;
    }

    public static GameResult from(List<Car> winners) {
        return new GameResult(winners);
    }

    public void gameResultPrint() {
        String result = winners.stream().map(Car::getName).collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + result);
    }
}
