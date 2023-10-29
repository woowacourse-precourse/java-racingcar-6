package racingcar.controller;

import java.util.List;
import racingcar.domain.Cars;
import racingcar.domain.CarsGenerator;
import racingcar.domain.Messenger;
import racingcar.domain.Round;
import racingcar.domain.strategy.CarMovementStrategy;
import racingcar.domain.strategy.MoveForwardOnceRandomlyStrategy;
import racingcar.utility.Convertor;
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
        String requestCarNamesMessage = messenger.getRequestCarNames();
        outputView.print(requestCarNamesMessage);

        String namesString = inputView.input();
        List<String> names = Convertor.split(namesString, Messenger.CAR_NAMES_DELIMITER);
        cars = carsGenerator.generateCarsFromNames(names);
    }

}