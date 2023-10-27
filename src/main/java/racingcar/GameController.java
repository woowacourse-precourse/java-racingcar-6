package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private List<String> carNames;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.carNames = new ArrayList<>();
    }

    public void play() {
        outputView.displayStartMessage();
        carNames = inputView.getCarNames();

        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            Car car = CarGenerator.createCar(name);
            cars.add(car);
        }
    }
}