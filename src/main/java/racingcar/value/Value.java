package racingcar.value;


import java.util.ArrayList;
import java.util.List;

public class Value {
    public List<String> carNames;

    public Value() {
        this.carNames = new ArrayList<>();
    }

    public void addCarNames(String[] names) {
        for (String name : names) {
            carNames.add(name);
        }
    }
}