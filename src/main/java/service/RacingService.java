package service;

import controller.dto.MoveResult;
import java.util.List;
import model.Car;
import model.Cars;
import model.RandomReferee;
import model.Referee;

public class RacingService {

    private final Referee referee;
    private final Cars cars;

    private RacingService(final Referee referee, final Cars cars) {
        this.referee = referee;
        this.cars = cars;
    }

    public static RacingService createDefault(final List<String> carNames) {
        Referee referee = new RandomReferee();
        return new RacingService(referee, Cars.from(carNames));
    }

    public static RacingService createServiceWithReferee(final Referee referee,
        final List<String> carNames) {
        return new RacingService(referee, Cars.from(carNames));
    }

    public List<MoveResult> moveEachCar() {
        cars.actEachCar(this::moveCarByReferee);
        return cars.getMoveResult();
    }

    private void moveCarByReferee(final Car car) {
        if (!referee.isSatisfiedCondition()) {
            return;
        }

        car.moveForward();
    }

    public List<String> getWinners() {
        return cars.getWinnerNames();
    }
}
