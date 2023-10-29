package racingcar.model.dto;

import java.util.List;
import racingcar.model.domain.Car;
import racingcar.model.domain.Game;
import racingcar.utils.Validator;

public class GameRequestDto {
    private final int trial;

    public GameRequestDto(String trial) {
        Validator.validateTrial(trial);
        this.trial = Integer.parseInt(trial);
    }

    public Game toGame(List<Car> cars) {
        return Game.of(cars, trial);
    }

    public int getTrial() {
        return trial;
    }
}
