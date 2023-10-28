package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarList;
import racingcar.domain.RandomNumber;
import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;

public class GameController {

    InputView inputView = new InputView();
    RandomNumber randomNumber = new RandomNumber();
    CarList carList = CarList.getInstance();

    int count; //시도할 횟수

    public void proceed() {
        init();
        startRace();
    }

    private void startRace() {
        for (int i = 0; i < count; i++) {
            carRace();
        }
    }

    private void carRace() {
        List<Car> cars = carList.getCars();
        for (Car car : cars) {
            carAdvanceOrStop(car);
        }
    }

    private void carAdvanceOrStop(Car car) {
        
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
