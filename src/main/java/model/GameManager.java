package model;

import model.dto.MoveResult;
import java.util.List;

public class GameManager {

    private final Referee referee;
    private final Cars cars;

    private GameManager(final Referee referee, final Cars cars) {
        this.referee = referee;
        this.cars = cars;
    }

    public static GameManager createDefault(final List<String> carNames) {
        Referee referee = new CompareNumberReferee();
        return new GameManager(referee, Cars.from(carNames));
    }

    public List<MoveResult> moveEachCar() {
        cars.actEachCar(this::moveCarByReferee);
        return cars.getMoveResult();
    }

    public List<String> getWinners() {
        return cars.getWinnerNames();
    }

    private void moveCarByReferee(final Car car) {
        if (!referee.isSatisfiedCondition()) {
            return;
        }

        car.moveForward();
    }
}
