package racingcar;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarList;
import racingcar.domain.TryCount;

public class RacingGame {
    private final OutputView outputView = new OutputView();
    public final InputView inputView = new InputView();
    private CarList carList;
    private TryCount tryCount;

    public void run() {
        init();
        moveForCount(tryCount.getCount());
        gameResult();
    }

    public void init() {
        outputView.inputCarNames();
        String carNames = inputView.inputCarNames();
        generateCar(carNames);

        outputView.inputTryCount();
        String count = inputView.inputTryCount();
        tryCount = new TryCount(count);

        outputView.printRunResult();
    }

    public void gameResult() {
        printWinners();
    }


    public void printWinners() {
        outputView.winnerOutput(carList.getWinnerNames());
    }

    public void moveForCount(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            carList.moveAllCars();
            printCarsStatus();
        }
    }

    public void printCarsStatus() {
        outputView.raceOutput(carList.getCarsStatus());
    }

    public List<Car> generateCar(String carNames) {
        List<Car> cars = Arrays.stream(carNames.split(","))
                .map(Car::new)
                .toList();
        carList = new CarList(cars);
        return cars;
    }
}
