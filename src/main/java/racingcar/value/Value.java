package racingcar.value;

import java.util.ArrayList;
import java.util.List;


public class Value {
    public List<String> carNames;
    int numberOfAttempts;

    public Value() {
        this.carNames = new ArrayList<>();
    }

    public void addCarNames(String[] names) {
        for (String name : names) {
            carNames.add(name);
        }
    }
    public void setNumberOfAttempts(int numberOfAttempts) {
        this.numberOfAttempts = numberOfAttempts;
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }
}