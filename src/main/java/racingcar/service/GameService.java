package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.Constant;
import racingcar.domain.Car;
import racingcar.domain.Game;

public class GameService {

    private Forward forward = new Forward();

    public void play(Game game) {
        moveForwardByRandomNumber(game);
        game.increaseTrialNum();
    }

    public List<String> findWinners(Game game) {
        List<Car> cars = game.getCars();
        int maxPosition = calculateMaxPosition(cars);
        return getMaxPositionCars(cars, maxPosition);
    }

    private void moveForwardByRandomNumber(Game game) {
        for (Car car : game.getCars()) {
            if (forward.isSuccessForward()) {
                car.moveForward(1);
            }
        }
    }

    private List<String> getMaxPositionCars(List<Car> cars, int maxPosition) {
        List<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            if (car.getCurrentPosition() == maxPosition) {
                carNames.add(car.getName());
            }
        }
        return carNames;
    }

    private int calculateMaxPosition(List<Car> cars) {
        int max = Constant.MIN_VALUE;
        for (Car car : cars) {
            if (max < car.getCurrentPosition()) {
                max = car.getCurrentPosition();
            }
        }
        return max;
    }
}
