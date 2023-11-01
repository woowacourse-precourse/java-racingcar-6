package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CarList;
import racingcar.model.RandomDrive;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.inputCarName();
        CarList carList = makeCarList(inputView.inputCarNames());
        outputView.inputAttempts();
        int racingNumber = inputView.inputRacingNumber();
        startRacing(carList, racingNumber);
        List<Car> winners = carList.findWinner(carList.getCarList());
        outputView.printWinner(winners);
    }

    private CarList makeCarList(List<String> names) {
        CarList carList = new CarList();
        for (String name : names) {
            Car car = new Car(name);
            carList.addCar(car);
        }
        return carList;
    }

    private void startRacing(CarList carList, int racingNumber) {
        outputView.printResultTitle();
        for (int i = 0; i < racingNumber; i++) {
            moveCars(carList);
        }
    }
    private void moveCars(CarList carList) {
        List<Car> cars = carList.getCarList();
        for (Car car : cars) {
            car.drive(RandomDrive.isDrive());
        }
        outputView.printResult(cars);
    }
}
