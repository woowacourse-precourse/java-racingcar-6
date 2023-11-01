package racingcar.domain;

import java.util.List;
import racingcar.utils.Input;

public class Player {

    private List<String> carNames;
    private Long gameCount;

    public List<String> getCarNames() {
        return carNames;
    }

    public Long getGameCount() {
        return gameCount;
    }

    public void inputCarNames() {
        this.carNames = Input.inputCarNames();
    }

    public void inputGameCount() {
        this.gameCount = Input.inputGameCount();
    }
}
