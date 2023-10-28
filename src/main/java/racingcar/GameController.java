package racingcar;

import racingcar.domain.Race;
import racingcar.ui.InputView;
import racingcar.ui.OutputView;
import racingcar.util.CarGenerator;

import java.util.ArrayList;
import java.util.List;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Race race;
    private List<String> carNames;
    private List<Car> cars;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.race = new Race();
        this.carNames = new ArrayList<>();
        this.cars = new ArrayList<>();
    }

    public void play() {
        outputView.displayStartMessage();
        carNames = inputView.getCarNames();

        for (String name : carNames) {
            Car car = CarGenerator.createCar(name);
            cars.add(car);
        }

        outputView.displayGetMoveCount();
        int moveCount = inputView.getMoveCount();
        race.racing(cars, moveCount);
    }
}