package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarList;
import racingcar.domain.RandomNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class GameController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    RandomNumber randomNumber = new RandomNumber();
    CarList carList = CarList.getInstance();
    private final int STANDARD_NUMBER = 4;

    int count; //시도할 횟수

    public void proceed() {
        init();
        startRace();
    }

    private void startRace() {
        String resultLog;
        for (int i = 0; i < count; i++) {
            resultLog = carRace();
            outputView.printExecutionResult(resultLog);
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
        Arrays.stream(cars).forEach(car -> Car.setCar(car));
    }
}
