package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.CarNames;
import racingcar.model.Move;
import racingcar.model.TryNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCar {

    private CarNames carNames;
    private TryNumber tryNumber;

    private Car[] cars;

    public void startGame() {
        getCarNames();
        getTryNumber();
        initializeCars();
        OutputView.printResultMessage();

        for (int i = 0; i < cars.length; i++) {
            OutputView.printCarStatus(cars[i].getName(), cars[i].getPosition());
        }
        System.out.println();

        simulateRacing();
        List<Car> winners = determineWinners();
        OutputView.printWinners(winners);
    }

    public void getCarNames() {
        carNames = new CarNames(InputView.setCarNames());
        List<String> carNamesList = carNames.getCarNames();
        cars = new Car[carNamesList.size()];
    }

    public void getTryNumber() {
        tryNumber = new TryNumber(InputView.setTryNumber());
        tryNumber.getTryNumber();
    }

    public void initializeCars() {
        List<String> carNamesList = carNames.getCarNames();
        cars = new Car[carNamesList.size()];

        for (int i = 0; i < carNamesList.size(); i++) {
            cars[i] = new Car(carNamesList.get(i));
        }
    }

    public void simulateRacing() {
        int tryCount = Integer.parseInt(tryNumber.getTryNumber());
        for (int i = 0; i < tryCount; i++) {
            moveCars();
            printCarStatus();
        }
    }

    public void printCarStatus() {
        for (Car car : cars) {
            OutputView.printCarStatus(car.getName(), car.getPosition());
        }
        System.out.println();
    }

    public void moveCars() {
        for (Car car : cars) {
            int randomNumber = new Move().randomNumberGenerator();
            if (new Move().canMove(randomNumber)) {
                car.move();
            }
        }
    }

    public List<Car> determineWinners() {
        int maxPosition = getMaxPosition();
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    public int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

}
