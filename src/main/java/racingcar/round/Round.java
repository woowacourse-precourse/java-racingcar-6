package racingcar.round;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.car.Car;

import java.util.List;

public class Round {
    List<Car> cars;

    public Round(List<Car> cars) {
        this.cars = cars;
    }

    public void startRound() {
        moveForward();
        printMovement();
    }

    private void printMovement() {
        for (Car car : cars) {
            printPerMovement(car.getCarName(), car.getCarDistance());
        }
        System.out.println();
    }

    private void printPerMovement(String name, int distance) {
        StringBuilder sb = new StringBuilder();
        sb.append(name);
        sb.append(" : ");
        sb.append(getFar(distance));

        System.out.println(sb);
    }

    private String getFar(int distance) {
        StringBuilder far = new StringBuilder();

        while (distance --> 0) {
            far.append("-");
        }

        return far.toString();
    }

    private void moveForward() {
        for (Car car : cars) {
            car.moveForwardOrNot(getRandomNumber());
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0,9);
    }
}
