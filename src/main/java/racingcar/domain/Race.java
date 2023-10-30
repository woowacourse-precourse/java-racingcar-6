package racingcar.domain;

import java.util.List;

public class Race {
    private List<Car> carList;
    private int moveCount;

    public Race() {
        init();
    }

    private void init() {
        carList = getCarNames();
        moveCount = getMoveCount();
    }

    public void start() {

    }

    private List<Car> getCarNames() {

    }

    private int getMoveCount() {

    }


}
