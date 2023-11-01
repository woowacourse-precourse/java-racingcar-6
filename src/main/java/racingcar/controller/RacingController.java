package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.view.InputManager;
import racingcar.view.OutputManager;

public class RacingController {
    private static RacingController racingController;
    private final InputManager inputManager = new InputManager();
    private final OutputManager outputManager = new OutputManager();
    private List<Car> cars;
    private List<Car> winCars = new ArrayList<>();
    private Integer tryCount;

    public RacingController() {
        this.cars = inputManager.inputCarNames();
        this.tryCount = inputManager.inputTryCount();
    }

    public void runRacing() {
        System.out.println(this.tryCount);
        outputManager.printMessage();
        while ((tryCount--) > 0) {
            cars.forEach(car -> car.advanceIfRandomIsAtLeastFour(Randoms.pickNumberInRange(0, 9)));
            outputManager.printCarStatus(cars);
        }
        determineWinCars();
        outputManager.printWinners(this.winCars);
    }

    private void determineWinCars() {
        final int maxAdvanceCount = this.cars.stream()
                .mapToInt(Car::getAdvanceCount)
                .max()
                .orElse(0);

        this.cars.forEach(car -> {
            if (car.getAdvanceCount() == maxAdvanceCount) {
                this.winCars.add(car);
            }
        });
    }

    public static RacingController getRacingController() {
        if (racingController == null) {
            racingController = new RacingController();
        }
        return racingController;
    }
}
