package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.CarsGenerator;
import racingcar.domain.Messenger;
import racingcar.domain.Round;
import racingcar.domain.strategy.CarMovementStrategy;
import racingcar.domain.strategy.MoveForwardOnceRandomlyStrategy;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame implements Game {

    private final InputView inputView;
    private final OutputView outputView;

    private final Messenger messenger = new Messenger();

    private final CarMovementStrategy carMovementStrategy = new MoveForwardOnceRandomlyStrategy();
    private final CarsGenerator carsGenerator = new CarsGenerator(carMovementStrategy);

    private Round round;
    private Cars cars;

    public RacingGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public void run() {

    }

}