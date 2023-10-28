package racingcar;

import Domain.TryCount;
import Domain.Cars;


public class RacingGame {
    public final Cars cars;
    public final TryCount tryCount;

    public RacingGame(String[] carNames, int tryCount) {
        this.cars = new Cars(carNames);
        this.tryCount = new TryCount(tryCount);
    }

    public void start() {
        System.out.println("실행 결과");
        for (int i = 0; i < tryCount.getValue(); i++) {
            cars.move();
        }
        System.out.println(cars.getWinners());
    }
}
