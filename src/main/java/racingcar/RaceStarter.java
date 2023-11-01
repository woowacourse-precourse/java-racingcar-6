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
        for (Car car : cars) {
            car.move();
        }
        System.out.print("\n");
    }

    void printWinner() {
        int maxMove = getMaxMove();
        System.out.print("최종 우승자 :");

        boolean comma = false;
        for (Car car : cars) {
            if (maxMove == car.movement) {
                addComma(comma);
                System.out.printf(" %s", car.carName);
            }
        }
    }

    void addComma(boolean comma) {
        if (comma) System.out.print(",");
        comma = true;
    }

    int getMaxMove() {
        List<Integer> movements = new ArrayList<>();
        for (Car car : cars) {
            movements.add(car.movement);
        }
        return Collections.max(movements);
    }

    void checkInputValidity(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

}
