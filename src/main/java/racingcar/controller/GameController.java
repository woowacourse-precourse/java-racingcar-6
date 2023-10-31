package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.NumberGenerator;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    private static final int INITIALIZE_POSITION = 0;

    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator = new RandomNumberGenerator();

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public List<Car> InitializeCars(List<String> carNames) {
        return carNames.stream()
                .map(carName -> new Car(carName,INITIALIZE_POSITION))
                .toList();
    }

}
