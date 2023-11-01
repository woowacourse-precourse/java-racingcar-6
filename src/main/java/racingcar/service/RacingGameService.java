package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingGame;
import racingcar.domain.RacingGameResult;

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

    public RacingGameResult findWinner(RacingGame game) {
        RacingGameResult gameResult = new RacingGameResult();
        List<Car> cars = game.getCars();
        long max = -1;
        for (Car car : cars) {
            if(car.getDistance() > max) {
                max = car.getDistance();
                gameResult.clear();
                gameResult.addWinner(car.getName());
            } else if(car.getDistance() == max) {
                gameResult.addWinner(car.getName());
            }
        }
        return gameResult;
    }

    public boolean canMove() {
        return RandomNumberGenerator.generateNumber() >= 4;
    }

}
