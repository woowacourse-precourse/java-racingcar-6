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

    public RacingGame(NumberGenerator numberGenerator) {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.numberGenerator = numberGenerator;
    }

    public void setupGame(List<String> carNames, int repeatCount) {
        this.carRepository = new CarRepository(carNames);
        this.repeatCount = repeatCount;
    }

    public void start() {
        setupGame(inputView.getCarsName(), inputView.getRepeatCount());
        play();
        outputView.printGameResult(carRepository.getMaxCars());
    }

    public void play() {
        for (int i = 0; i < repeatCount; i++) {
            oneRoundMove();
            outputView.printOneRoundResult(carRepository);
        }
    }

    public void oneRoundMove() {
        List<Car> cars = carRepository.getCars();
        for (Car car : cars) {
            if (isMove(numberGenerator.randomNumber())) {
                car.moveForward();
            }
        }
    }

    public boolean isMove(int num) {
        return MOVE_RULE <= num;
    }

    public CarRepository getCarRepository() {
        return carRepository;
    }

    public int getRepeatCount() {
        return repeatCount;
    }
}
