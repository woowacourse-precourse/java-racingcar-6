package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarList;
import racingcar.domain.RandomNumber;
import racingcar.validation.Validator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class GameController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    RandomNumber randomNumber = new RandomNumber();
    Validator validator = new Validator();
    CarList carList = CarList.getInstance();
    private final int STANDARD_NUMBER = 4;

    int count; //시도할 횟수

    public void proceed() {
        init();
        startRace();
        Winner();
    }

    private void Winner() {
        List<Car> cars = carList.getCars();
        List<String> winners = new ArrayList<>();
        int maxLevel = maxNum(cars);
        for (Car car : cars) {
            checkMaxCar(car, maxLevel, winners);
        }
        outputView.printWinner(String.join(",",winners));
    }

    private void checkMaxCar(Car car, int maxLevel, List<String> winners) {
        if (car.getLevel() == maxLevel) {
            winners.add(car.getCarName());
        }
    }

    private int maxNum(List<Car> cars) {
        Comparator<Car> comparator = ((o1, o2) -> o2.getLevel() - o1.getLevel());
        cars.sort(comparator);

        return cars.get(0).getLevel();
    }

    private void startRace() {
        String resultLog;

        outputView.printExecutionResult();
        for (int i = 0; i < count; i++) {
            resultLog = carRace();
            outputView.printCarRacingResult(resultLog);
        }
    }

    private String carRace() {
        List<Car> cars = carList.getCars();
        StringBuilder sb = new StringBuilder();

        for (Car car : cars) {
            carAdvanceOrStop(car);
            makeLog(car, sb);
        }

        return String.valueOf(sb);
    }

    private void makeLog(Car car, StringBuilder sb) {
        String carNameAndLog = car.getCarNameAndLog();
        sb.append(carNameAndLog + "\n");
    }

    private void carAdvanceOrStop(Car car) {
        int number = randomNumber.makeNumber();
        if (checkNumber(number)) {
            car.setLevelAndLog(car);
        }
    }

    private boolean checkNumber(int number) {
        return number >= STANDARD_NUMBER;
    }

    /**
     * 경주에 참여할 자동차를 정리하고 시도할 횟수 지정
     */
    private void init() {
        String carNames = inputView.printCarName();
        carsToList(carNames);
        count = inputView.printTryCount();
    }

    private void carsToList(String carNames) {
        String[] cars = carNames.split(",");
        for (String car : cars) {
            validator.valid(car);
        }
        Arrays.stream(cars).forEach(car -> Car.setCar(car));
    }
}
