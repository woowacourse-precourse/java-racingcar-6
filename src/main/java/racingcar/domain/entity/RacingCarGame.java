package racingcar.domain.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.domain.service.input.RegisterRacingCarGameInput;
import racingcar.exception.RacingCarGameException;

public class RacingCarGame extends Game {
    private List<String> winnerNames = new ArrayList<>();
    private Long gameCount;
    private List<Car> cars = new ArrayList<>();

    private RacingCarGame() {
    }

    public static RacingCarGame createWithoutWinnerNames(RegisterRacingCarGameInput input) {
        RacingCarGame racingCarGame = new RacingCarGame();
        racingCarGame.init(input.getRacingGameId(), input.getGameType());
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

    public void changeCars(List<Car> cars) {
        this.cars = cars;
    }

    public void changeGameCount(Long gameCount) {
        this.gameCount = gameCount;
        if (gameCount < 0) {
            throw new RacingCarGameException(RacingCarGameException.NON_NEGATIVE_GAME_COUNT_RESTRICTION);
        }
    }

    public void changeWinnerNames(List<String> winnerNames) {
        this.winnerNames = winnerNames;
    }
}
