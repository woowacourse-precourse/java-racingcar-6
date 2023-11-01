package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;

public class RacingGameService {

    public static RacingGameService startGame() {
        return new RacingGameService();
    }

    private RacingGameService() {

    }

    public RacingGame moveCar(RacingGame game) {
        List<Car> cars = game.getCars();
        for (Car car : cars) {
            if(canMove()) {
                car.addDistance();
            }
        }
        game.decreaseN();
        return game;
    }


    public boolean canMove() {
        return RandomNumberGenerator.generateNumber() >= 4;
    }

}
