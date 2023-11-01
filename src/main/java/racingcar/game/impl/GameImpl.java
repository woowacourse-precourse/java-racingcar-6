package racingcar.game.impl;

import java.util.List;
import racingcar.car.Car;
import racingcar.game.Game;
import camp.nextstep.edu.missionutils.Randoms;

public class GameImpl implements Game {
    private List<Car> cars;
    private final int moveNumber;

    public GameImpl(List<Car> cars, int moveNumber) {
        this.cars = cars;
        this.moveNumber = moveNumber;
    }

    private void tryMove() {
        cars.forEach(car -> {
            int dice = Randoms.pickNumberInRange(0, 9);
            if (dice >= 4) {
                car.move();
            }
        });
    }

    @Override
    public void play() {
        for (int i = 0 ; i < moveNumber ; i++) {
            tryMove();
        }
    }

    @Override
    public void end() {

    }
}
