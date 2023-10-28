package racingcar.model.dto;

import java.util.List;
import racingcar.model.domain.Car;
import racingcar.model.domain.Game;
import racingcar.utils.Validator;
import racingcar.utils.ValidatorImp;

public class GameRequestDto {
    private static final Validator validator = new ValidatorImp();
    private final int trial;

    public GameRequestDto(String trial) {
        validator.validateTrial(trial);
        this.trial = Integer.parseInt(trial);
    }

    public Game toGame(List<Car> cars) {
        return Game.of(cars, trial);
    }

    public int getTrial() {
        return trial;
    }
}
