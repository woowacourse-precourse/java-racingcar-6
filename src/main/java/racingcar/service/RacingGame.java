package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGame {

    public void play() {
        List<String> carNames = GetCarNames();
        int trialRounds = GetTrialRounds();
        List<Car> cars = createCars(carNames);
        OutputView.showStatus();
        for (int round = 0; round < trialRounds; round++) {
            moveCars(cars);
            printCurrentStatus(cars);
        }
        List<String> winners = getWinners(cars);
        OutputView.showWinners(winners);
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private void moveCars(List<Car> cars) {
        for (Car car : cars) {
            car.move(Randoms.pickNumberInRange(0, 9));
        }
    }

    private void printCurrentStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getPositionString());
        }
        System.out.println();
    }

    private List<String> getWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
                winners.clear();
                winners.add(car.getName());
            }
        }
        return winners;
    }
    private List<String> GetCarNames() {
        String inputCars = InputView.inputCarNames();
        boolean result = Validator.isValidCar(inputCars);
        if (!result) {
            throw new IllegalArgumentException(OutputView.ERROR);
        }
        return Arrays.asList(inputCars.split(","));
    }
    private int GetTrialRounds() {
        String inputRounds = InputView.inputRound();
        boolean result = Validator.isValidNum(inputRounds);
        if (!result) {
            throw new IllegalArgumentException(OutputView.ERROR);
        }
        return Integer.parseInt(inputRounds);
    }
}
