package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CarGame {
    private final List<Cars> cars = new ArrayList<>();
    private int playCount;

    public void setCarsName(String name) {
        divideName(name);
        Validation.name(cars);
    }

    public List<Cars> getCarsName() {
        return cars;
    }

    public void setPlayCount(String playCount) {
        Validation.isPositiveInt(playCount);
        this.playCount = Integer.parseInt(playCount);
    }



    private void divideName(String name) {
        StringTokenizer tokenizer = new StringTokenizer(name.trim(),",");

        while (tokenizer.hasMoreTokens()) {
            String result = tokenizer.nextToken().trim();
            cars.add(new Cars(result, 0));
        }
    }
}
