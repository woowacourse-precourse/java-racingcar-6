package racingcar.model.service;

import static racingcar.model.constants.Rule.MOVE_VALUE;

import racingcar.model.domain.Car;
import racingcar.model.domain.Game;
import racingcar.utils.Generator;
import racingcar.utils.GeneratorImp;

public class RacingCarServiceImp implements RacingCarService {
    private final Generator generator = new GeneratorImp();

    @Override
    public boolean isEnd(Game game) {
        return game.isFinished();
    }

    @Override
    public void moveCars(Game game) {
        for (Car car : game.getCars()) {
            if (MOVE_VALUE.getValue() <= getRandomNumber()) {
                car.move();
            }
        }
        increaseTrial(game);
    }

    private int getRandomNumber() {
        return generator.generateRandomNumber();
    }

    private void increaseTrial(Game game) {
        game.increaseCount();
    }
}
