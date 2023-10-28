package racingcar;

import racingcar.factories.CarRecordFactory;
import racingcar.factories.RefereeFactory;

public class Race {

    private GameRule rule;
    private Referee referee;
    private CarRecord racers;

    public Race(GameRule rule) throws IllegalArgumentException {
        this.rule = rule;
    }

    public void registerRacers(CarRecord carRecord) {
        this.racers = carRecord;
        this.referee = RefereeFactory.referee(racers);
    }

    public void start() {
        for (int i = 0; i < rule.getN(); i++) {
            racers.moveForwardAllCars();
            racers.printCurrentPositions();
        }
    }

    public String winners() {
        return referee.announceAllWinners();
    }
}
