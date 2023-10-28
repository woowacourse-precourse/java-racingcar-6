package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.CarRepository;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

import static racingcar.constant.Constants.MOVE_RULE;

public class RacingGame {
    private final InputView inputView;
    private final OutputView outputView;
    private CarRepository carRepository;
    private int repeatCount;

    public RacingGame() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
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

    private void play() {
        for (int i = 0; i < repeatCount; i++) {
            OneRoundMove();
            outputView.printOneRoundResult(carRepository);
        }
    }

    private void OneRoundMove() {
        List<Car> cars = carRepository.getCars();
        for (Car car : cars) {
            if (isMove()) {
                car.moveForward();
            }
        }
    }

    private boolean isMove() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        return MOVE_RULE <= randomNum;
    }

    public void setupGame() {
        initialize(inputView.getCarsName(), inputView.getRepeatCount());
    }

}
