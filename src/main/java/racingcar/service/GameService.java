package racingcar.service;

import java.util.List;
import racingcar.domain.InputManager;
import racingcar.domain.Movable;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

public class GameService {

    public static void racingStart(InputManager inputManager) {
        int round = inputManager.getGameProcessCount();
        List<Car> parsedCarList = inputManager.getParsedCarList();
        Cars cars = new Cars(parsedCarList);
        for (int i = 0; i < round; i++) {
            cars.oneTurnContinue(new Movable());
        }
    }


}
