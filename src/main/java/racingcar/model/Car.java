package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Car {
    private List<String> carName = new ArrayList<>();
    private int playCount;

    public void setCarName(String name) {
        divideName(name);
        Validation.name(carName);
    }

    public List<String> getCarName() {
        return carName;
    }

    private void divideName(String name) {
        StringTokenizer tokenizer = new StringTokenizer(name.trim(),",");

        while (tokenizer.hasMoreTokens()) {
            carName.add(tokenizer.nextToken().trim());
        }
    }
}
