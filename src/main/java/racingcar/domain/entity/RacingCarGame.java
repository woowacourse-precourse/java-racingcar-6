package racingcar.domain.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.input.RacingCarGameInput;

public class RacingCarGame extends Game {
    private List<String> winnerNames = new ArrayList<>();
    private Long gameCount;
    private List<Car> cars = new ArrayList<>();

    private RacingCarGame() {
    }

    public static RacingCarGame createWithoutWinnerNames(RacingCarGameInput input) {
        RacingCarGame racingCarGame = new RacingCarGame();
        racingCarGame.init(input.getRacingGameId(), input.getGameName());
        racingCarGame.gameCount = Long.parseLong(input.getGameCount());
        racingCarGame.cars = input.getCars();

        return racingCarGame;
    }

    public List<String> getWinnerNames() {
        return Collections.unmodifiableList(winnerNames);
    }

    public Long getGameCount() {
        return gameCount;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
