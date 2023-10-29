package racingcar.domain;

import java.util.List;

public class InputManager {
    private final int gameProcessCount;
    private final List<String> inputCarList;

    public InputManager(int gameProcessCount, List<String> inputCarList) {
        this.gameProcessCount = gameProcessCount;
        this.inputCarList = inputCarList;
    }

    public int getGameProcessCount() {
        return gameProcessCount;
    }

    public List<String> getInputCarList() {
        return inputCarList;
    }
}
