package racingcar.domain;

import java.util.List;

public class RacingGame {

    private final Navigation navigation;
    private final Counter counter;

    public RacingGame(List<Car> carList, int count) {
        navigation = new Navigation(carList);
        this.counter = new Counter(count);
    }

    public void doRace() {
        navigation.moveAll();
        counter.reduceCount();
    }

    public List<Car> getStatus() {
        return navigation.getList();
    }

    public boolean isEnd() {
      return counter.isEnd();
    }
}
