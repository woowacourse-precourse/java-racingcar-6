package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<Car> carList = new ArrayList<>();
    private final List<String> carNameList;
    private final int tryCount;

    public Race(List<String> carNameList, int tryCount) {
        this.carNameList = carNameList;
        this.tryCount = tryCount;
    }

    public void start() {
        return;
    }
}
