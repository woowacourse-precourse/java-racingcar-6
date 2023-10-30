package racingcar.domain.service.input;

import java.util.List;
import racingcar.domain.entity.Car;
import racingcar.domain.entity.GameType;

public class RegisterRacingCarGameInput {
    private Long racingGameId;
    private GameType gameType;
    private String gameCount;
    private List<Car> cars;

    public RegisterRacingCarGameInput(Long racingGameId, GameType gameName, String gameCount, List<Car> cars) {
        this.racingGameId = racingGameId;
        this.gameType = gameName;
        this.gameCount = gameCount;
        this.cars = cars;
    }

    public Long getRacingGameId() {
        return racingGameId;
    }

    public GameType getGameType() {
        return gameType;
    }

    public String getGameCount() {
        return gameCount;
    }

    public List<Car> getCars() {
        return cars;
    }
}
