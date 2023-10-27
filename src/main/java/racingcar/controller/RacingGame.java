package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.CarRepository;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    public static final int MOVE_RULE = 4;
    private final InputView inputView;
    private final OutputView outputView;
    private CarRepository carRepository;
    private int repeatCount;

    public RacingGame(List<String> cars, int repeatCount) {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        carRepository = new CarRepository(cars);
        this.repeatCount = repeatCount;
    }

    public RacingGame() {
        this(new ArrayList<>(), 10);
    }

    public void start() {
        setupGame();
        System.out.println(carRepository + " " + repeatCount);
        play();
        outputView.getResult(carRepository.getMaxCars());
    }

    private void play() {
        for (int i = 0; i < repeatCount; i++) {
            OneRoundMove();
            outputView.printOneRoundResult(carRepository);
            System.out.println(carRepository + " " + i);
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
        this.carRepository = new CarRepository(inputView.getCarsName());
        this.repeatCount = inputView.getRepeatCount();
    }

}
