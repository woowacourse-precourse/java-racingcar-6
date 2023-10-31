package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {

    private final List<Car> cars;

    private final OutputView outputView;

    private final InputView inputView;

    public Game(OutputView outputView, InputView inputView) {
        cars = new ArrayList<>();
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        outputView.printStartMessage();
        registerCars();
    }

    private void registerCars() {
        List<String> namesOfCars = inputView.readNamesOfCars();
        for (String name : namesOfCars) {
            cars.add(Car.getInstance(name));
        }
    }
}
