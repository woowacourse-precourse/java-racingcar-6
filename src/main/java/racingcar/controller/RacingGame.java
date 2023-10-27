package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.CarRepository;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    public static final int MOVE_RULE = 4;
    private final InputView inputView;
    private CarRepository carRepository;
    private int repeatCount;

    public RacingGame(List<String> cars, int repeatCount) {
        this.inputView = new InputView();
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
    }

    private void play() {
        while (repeatCount-- > 0) {
            OneRoundMove();
            System.out.println(carRepository + " " + repeatCount);
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
