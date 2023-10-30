package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final Navigation navigation;
    private int count;

    public RacingGame(ArrayList<Car> carList, int count) {
        navigation = new Navigation(carList);
        this.count = count;
    }

    public void doRace() {
        navigation.moveAll();
        reduceCount();
    }

    public List<Car> getStatus() {
        return navigation.getList();
    }

    public boolean isEnd() {
        if (count <= 0) {
            return true;
        }
        return false;
    }

    private void reduceCount() {
        count--;
    }
}
