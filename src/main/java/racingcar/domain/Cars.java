package racingcar.domain;

import java.util.List;

public class Cars {
    List<String> carNames;
    int gameCount;

    public Cars(List<String> carNames, int gameCount) {
        this.carNames = carNames;
        this.gameCount = gameCount;
    }

}
