package racingcar.domain;

import racingcar.view.Output;

public class Game {
    private final Cars cars;
    private final Round round;

    private Game(final Cars cars, final Round round) {
        this.cars = cars;
        this.round = round;
    }

    public static Game of(final Cars cars, final Round round) {
        return new Game(cars, round);
    }

    public void play(final MovingStrategy movingStrategy) {
        while (round.canPlay()) {
            cars.moveAll(movingStrategy);
            round.nextRound();
        }
        Output.printWinners(Winner.createFrom(cars));
    }
}
