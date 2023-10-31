package racingcar;

import java.util.ArrayList;
import java.util.List;

public class User {

    List<String> carNames = new ArrayList<>();
    private int tryCount = 0;

    public void inputCarName() {
        validateCarName();
    }

    public void inputTryCount() {
        validateTryCount();
    }

    private void validateCarName() {
    }

    private void validateTryCount() {
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getTryCount() {
        return tryCount;
    }
}
