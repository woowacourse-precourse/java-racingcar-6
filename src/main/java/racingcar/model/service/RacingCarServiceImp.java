package racingcar.model.service;

import static racingcar.model.constants.Rule.MOVE_VALUE;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.domain.Car;
import racingcar.model.domain.Game;
import racingcar.utils.Generator;

public class RacingCarServiceImp implements RacingCarService {
    @Override
    public void moveCars(Game game) {
        for (Car car : game.getCars()) {
            if (MOVE_VALUE.getValue() <= getRandomNumber()) {
                car.move();
            }
        }
        increaseTrial(game);
    }

    @Override
    public List<String> getWinner(Game game) {
        int maxLocation = getMaxLocation(game.getCars());
        return getMaxLocationCars(game.getCars(), maxLocation);
    }

    private static List<String> getMaxLocationCars(List<Car> cars, int maxLocation) {
        List<String> carNames = new ArrayList<>();
        for (Car car : cars) {
            if (car.getLocation() == maxLocation) {
                carNames.add(car.getName());
            }
        }
        return carNames;
    }

    private static int getMaxLocation(List<Car> cars) {
        int max = 0;
        for (Car car : cars) {
            if (max < car.getLocation()) {
                max = car.getLocation();
            }
        }
        return max;
    }

    private static int getRandomNumber() {
        return Generator.generateRandomNumber();
    }

    private static void increaseTrial(Game game) {
        game.increaseCount();
    }
}
