package racingcar.input;

import java.util.List;
import racingcar.domain.entity.Car;
import racingcar.domain.entity.GameType;

public class RacingCarGameInput {
    private Long racingGameId;
    private GameType gameName;
    private String gameCount;
    private List<Car> cars;

    public RacingCarGameInput(Long racingGameId, GameType gameName, String gameCount, List<Car> cars) {
        this.racingGameId = racingGameId;
        this.gameName = gameName;
        this.gameCount = gameCount;
        this.cars = cars;
    }

    public Long getRacingGameId() {
        return racingGameId;
    }

    public GameType getGameName() {
        return gameName;
    }

    public String getGameCount() {
        return gameCount;
    }

    public List<Car> getCars() {
        return cars;
    }
}
