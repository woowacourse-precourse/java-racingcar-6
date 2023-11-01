package racingcar.Domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Racing {

    public int carSpeed() {
        return Randoms.pickNumberInRange(1, 9);
    }

    public boolean checkFastEnough() {
        return carSpeed() >= 4;
    }

    public void racingResult(List<Car> cars) {
        for (Car car : cars) {
            if (checkFastEnough()) {
                car.moveForward();
            }
        }
    }

    public void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");

            for (int i = 0; i < car.getMovingDistance(); i++) {
                System.out.print("-");
            }
            System.out.println("\n");
        }
    }

    public void attemptsNumberInput() {
        System.out.print("시도할 회수는 몇회인가요?\n");
        String attemptsNumber = Console.readLine().trim();

        validateFormat(attemptsNumber);
    }

    private void validateFormat(String attemptsNumber) {
        if (!attemptsNumber.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException();
        }
    }
}
