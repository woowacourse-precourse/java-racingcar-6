package racingcar.domain.game;

import racingcar.domain.car.Cars;
import racingcar.domain.policy.MoveRule;
import racingcar.domain.race.Race;

public class Game {
    private final Race race;
    private final GameOperator gameOperator;

    public Game(MoveRule moveRule, GameOperator gameOperator) {
        this.race = new Race(moveRule);
        this.gameOperator = gameOperator;
    }

    public String play() {
        StringBuilder result = new StringBuilder();

        Cars cars = generateCars();

        result.append(race(cars));
        result.append(printWinner(cars));

        return result.toString();
    }

    private Cars generateCars() {
        return gameOperator.generateCars();
    }

    private StringBuilder race(Cars cars) {
        StringBuilder result = new StringBuilder();
        int trial = getTrial();

        for (int i = 0; i < trial; i++) {
            race.run(cars);
            result.append(cars.printPosition()).append("\n");
        }

        return result;
    }

    private int getTrial() {
        return gameOperator.setTrial();
    }

    private String printWinner(Cars cars) {
        return "최종 우승자 : " + cars.getWinner();
    }
}
