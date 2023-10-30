package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarRepository;
import racingcar.util.GameNumberGenerator;
import racingcar.util.NumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

import static racingcar.constant.Constants.MOVE_RULE;

public class RacingGame {
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberGenerator numberGenerator;
    private CarRepository carRepository;
    private int repeatCount;

    public RacingGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.numberGenerator = new GameNumberGenerator();
    }

    public void initialize(List<String> carNames, int repeatCount) {
        this.carRepository = new CarRepository(carNames);
        this.repeatCount = repeatCount;
    }

    public void start() {
        setupGame();
        play();
        outputView.getResult(carRepository.getMaxCars());
    }

    public void play() {
        for (int i = 0; i < repeatCount; i++) {
            OneRoundMove();
            outputView.printOneRoundResult(carRepository);
        }
    }

    public void OneRoundMove() {
        List<Car> cars = carRepository.getCars();
        for (Car car : cars) {
            if (isMove()) {
                car.moveForward();
            }
        }
    }

    public boolean isMove() {
        return MOVE_RULE <= numberGenerator.randomNumber();
    }

    public void setupGame() {
        initialize(inputView.getCarsName(), inputView.getRepeatCount());
    }

}
