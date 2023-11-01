package racingcar.Domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Race {

    private final List<Car> cars;

    public Race(List<Car> cars) {
        this.cars = cars;
    }

    private int carSpeed() {
        return Randoms.pickNumberInRange(1, 9);
    }

    private boolean checkFastEnough() {
        return carSpeed() >= 4;
    }

    private void racingResult() {
        for (Car car : this.cars) {
            if (checkFastEnough()) {
                car.moveForward();
            }
        }
    }

    private void printResult() {
        for (Car car : this.cars) {
            System.out.print(car.getName() + " : ");

            for (int i = 0; i < car.getMovingDistance(); i++) {
                System.out.print("-");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public void result(int attemptsNumber) {
        System.out.print("\n실행 결과\n");

        for (int i = 0; i < attemptsNumber; i++) {
            racingResult();
            printResult();
        }
    }
}
