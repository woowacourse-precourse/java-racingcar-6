package racingcar.domain;

import java.util.List;

public class InputManager {
    private final int gameProcessCount;
    private final String inputCarList;

    public InputManager(int gameProcessCount, String inputCarList) {
        this.gameProcessCount = gameProcessCount;
        this.inputCarList = inputCarList;
    }

    public int getGameProcessCount() {
        return gameProcessCount;
    }

    public String getInputCarList() {
        return inputCarList;
    }
}
