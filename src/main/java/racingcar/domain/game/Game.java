package racingcar.domain.game;

import racingcar.domain.car.Cars;
import racingcar.domain.policy.DriveRule;
import racingcar.domain.race.Race;

public class Game {
    private final Race race;
    private final GameOperator gameOperator;

    public Game(DriveRule driveRule, GameOperator gameOperator) {
        this.race = new Race(driveRule);
        this.gameOperator = gameOperator;
    }

    public String run() {
        StringBuilder result = new StringBuilder();

        Cars cars = generateCars();
        int trial = getTrial();

        result.append(race(cars, trial));
        result.append(printWinner(cars));

        return result.toString();
    }

    private Cars generateCars() {
        return gameOperator.generateCars();
    }

    private int getTrial() {
        return gameOperator.setTrial();
    }

    private StringBuilder race(Cars cars, int trial) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < trial; i++) {
            race.run(cars);
            result.append(cars.printPosition()).append("\n");
        }

        return result;
    }

    private String printWinner(Cars cars) {
        return "최종 우승자 : " + cars.getWinner();
    }
}
