package racingcar.game;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.Car;
import racingcar.game.validate.EmptyCarNamesValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGame {

    private final InputView inputView;
    private final OutputView outputView;
    private List<Car> cars;

    public RacingGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        receiveCarNames();
    }

    private void receiveCarNames() {
        outputView.inputCarsNames();
        List<String> carNames = inputView.getCarNames();
        EmptyCarNamesValidator.validate(carNames);
        this.cars = carNames.stream().map(Car::new).collect(Collectors.toList());
    }
}
