package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.constants.GameConstants;
import racingcar.view.output.GameOutputView;

public class GameResult {
    private final GameOutputView gameOutputView = new GameOutputView();
    private List<Car> winners;

    private GameResult(List<Car> winners) {
        this.winners = winners;
    }

    public static GameResult from(List<Car> winners) {
        return new GameResult(winners);
    }

    public void gameResultPrint() {
        String result = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(GameConstants.JOIN_COMMA_SEPARATOR));
        gameOutputView.printGameResult(result);
    }
}
