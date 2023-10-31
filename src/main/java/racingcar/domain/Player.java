package racingcar.domain;

import java.util.List;
import racingcar.utils.Input;

public class Player {

    private List<String> carNames;

    public List<String> getCarNames() {
        return carNames;
    }


    public void inputCarNames() {
        this.carNames = Input.inputCarNames();
    }

}
