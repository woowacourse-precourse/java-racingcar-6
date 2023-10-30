package racingcar.domain;

import java.util.List;
import racingcar.dto.RacingGameRequest;

public class RacingGame {

    private final Navigation navigation;
    private final Counter counter;

    public RacingGame(RacingGameRequest request) {
        this(request.getCars(),request.getCount());
    }

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

    public List<String> getWinner() {
        List<Car> winner=navigation.determineWinner();
        return winner.stream().map(Car::getName).toList();
    }
}
