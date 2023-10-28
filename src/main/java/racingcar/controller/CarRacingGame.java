package racingcar.controller;

import racingcar.TryNumber;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class CarRacingGame {

    public void start() {
        Cars cars = new Cars();

        setCarsName(cars);
        setTryNumber(cars);
    }

    public void setCarsName(Cars cars) {

        try {
            cars.addCar(InputView.printSetCarsNameMessage());
        } catch (IllegalArgumentException e){

        }
    }

    public void setTryNumber(Cars cars) {
        try {
            cars.setTryNumber(InputView.printGetTryNumberMessage());
        } catch (IllegalArgumentException e){

        }
    }

    // 각 자동차 전진한 만큼 출력하기
    public void printCarsPosition(Cars cars) {
        for (Car car : cars.getCarList()){
            car.selectMoveOrStop();
            OutputView.printCarName(car.getName());
            OutputView.printCarPosition(car.getPosition());
            OutputView.printSpace();
        }
        OutputView.printSpace();
    }

    // 입력한 시도 횟수 만큼 출력하기
    public void printAllTry(Cars cars) {
        for (int i = 0; cars.getTryNumber() > i; i++) {
            printCarsPosition(cars);
        }
    }

    private void printWinner(Cars cars) {
        OutputView.printWinner(getWinner(cars));
    }

    private String getWinner(Cars cars) {
        return cars.getWinner(cars.getCarsPosition());
    }

}