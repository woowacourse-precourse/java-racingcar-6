package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.User;
import racingcar.view.InputView;
import racingcar.view.OutputView;
import java.util.Map;

public class RacingCarController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Car car;
    private final User user;
    private final Map<String,Integer> carMap;

    public RacingCarController() {
        outputView.start();
        this.car = new Car(inputView.createCar());
        outputView.moveSize();
        this.user = new User(inputView.moveSize());
        this.carMap = car.getCarMap();
    }
}
