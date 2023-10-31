package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.util.Constant;

public class GameService {
    public GameService() {
    }

    public static GameService getInstance() {
        return GameService.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final GameService INSTANCE = new GameService();
    }

    public List<Car> toCarList(String input) {
        List<Car> cars = new ArrayList<>();

        for (String car : input.split(Constant.SPLIT_UNIT)) {
            cars.add(new Car(car));
        }

        return cars;
    }

    public Boolean canMove(int value) {
        return value >= Constant.MIN_CAN_MOVE_VALUE;
    }

    public List<String> toCarString(List<Car> cars) {
        List<String> oneCarResults = new ArrayList<>();

        for (Car car : cars) {
            String name = car.getName();
            String moving = toMovingString(car.getMoving());
            String result = String.format(Constant.ONE_CAR_RESULT, name, moving);

            oneCarResults.add(result);
        }

        return oneCarResults;
    }

    public String toMovingString(int moving_int) {
        return Constant.MOVING_UNIT.repeat(moving_int);
    }

    public List<String> getWinner(List<Car> cars) {
        int maxMoving = -1;
        List<String> carNames = new ArrayList<>();

        for (Car car : cars) {
            int moving = car.getMoving();

            if (maxMoving < moving) {
                maxMoving = moving;
                carNames.clear();
            }

            if (maxMoving == moving) {
                carNames.add(car.getName());
            }
        }

        return carNames;
    }
}
