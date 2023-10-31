package racingcar.underhood;

import racingcar.factories.RefereeFactory;

public class Race extends RacingGameComponent {

    private Referee referee;
    private CarRecord racers;

    public Race(GameRule rule) throws IllegalArgumentException {
        super(rule);
    }

    public void registerRacers(CarRecord carRecord) {
        this.racers = carRecord;
        this.referee = RefereeFactory.referee(racers);
    }

    public void start() {
        for (int i = 0; i < rule.getNumberOfRepetitions(); i++) {
            racers.moveForwardAllCars();
            racers.printCurrentPositions();
        }
    }

    public String winners() {
        return referee.announceAllWinners();
    }
}
