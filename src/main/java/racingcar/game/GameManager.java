package racingcar.game;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.input.InputAdaptor;

public class GameManager {
    private final String[] cars;
    private final int numOfTries;

    public GameManager(String[] cars, int numOfTries) {
        this.cars = cars;
        this.numOfTries = numOfTries;
    }

    private boolean isSuccessToProceed() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
