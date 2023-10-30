package racingcar;

import java.util.*;

public class RaceStarter {

    List<Car> cars = new ArrayList<>();
    int moveNum;

    public RaceStarter(String str, int moveNum) {
        getCars(str);
        this.moveNum = moveNum;
    }

    void getCars(String str) {
        String[] carNames = str.split(",");
        for (String carName : carNames) {
            checkInputValidity(carName);
            Car car = new Car(carName);
            cars.add(car);
        }
    }

    void start() {
        for (int num = 0; num < moveNum; num++) {
            doSet();
        }
        printWinner();
    }

    void doSet() {

    }

    void printWinner() {

    }

    void checkInputValidity(String name) {

    }

}
