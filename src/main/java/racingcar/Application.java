package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {

    private static int ASCIIZERO = 48;
    private static int ASCIININE = 57;
    private static int MOVE_NUMBER = 4;

    private static class Car {

        String carName;
        int location;

        Car(final String carName) {
            this.carName = carName;
            this.location = 0;
        }

        private String getCarName() {
            return this.carName;
        }

        private void move() {
            this.location++;
        }

        private int getLocation() {
            return this.location;
        }
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현


        String[] carNames = inputCarNames();
        int attemptsNum = inputAttemptsNum();

        List<Car> cars = createCars(carNames);

        for (Car car : cars) {
            System.out.print(car.getCarName() + " ");
            System.out.println(car.getLocation());
        }
        moveCars(cars);
        for (Car car : cars) {
            System.out.print(car.getCarName() + " ");
            System.out.println(car.getLocation());
        }
    }

    private static List<Car> createCars(final String[] carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    private static void moveCars(final List<Car> cars) {
        for (Car car : cars) {
            if (canMove()) {
                car.move();
            }
        }
    }

    private static String[] inputCarNames() {
        String[] carNames = Console.readLine().split(",");

        if (!validateCarNames(carNames)) {
            throw new IllegalArgumentException("자동차 이름의 길이가 5를 초과 했습니다.");
        }

        return carNames;
    }

    private static int inputAttemptsNum() {
        String attemptsNum = Console.readLine();

        if (!validateAttemptsNum(attemptsNum)) {
            throw new IllegalArgumentException("잘못된 시도 횟수 입니다.");
        }

        return Integer.parseInt(attemptsNum);
    }

    private static boolean validateCarNames(final String[] carNames) {
        for (String carName : carNames) {
            if (!validateCarNameLength(carName)) {
                return false;
            }
        }

        return true;
    }

    private static boolean validateCarNameLength(final String carName) {
        if (carName.length() > 5) {
            return false;
        }

        return true;
    }

    private static boolean validateAttemptsNum(final String attemptsNum) {
        if (!validateAttemptsNumIsNumber(attemptsNum) || !validateAttemptsNumIsZero(attemptsNum)) {
            return false;
        }

        return true;
    }

    private static boolean validateAttemptsNumIsNumber(final String attemptsNum) {
        String[] splitAttemptsNums = attemptsNum.split("");

        for (String splitAttemptsNum : splitAttemptsNums) {
            if (!isNumber(splitAttemptsNum)) {
                return false;
            }
        }

        return true;
    }

    private static boolean validateAttemptsNumIsZero(final String attemptsNum) {
        int intAttemptsNum = Integer.parseInt(attemptsNum);

        if (intAttemptsNum == 0) {
            return false;
        }

        return true;
    }

    private static boolean isNumber(final String splitAttemptsNum) {
        if(ASCIIZERO > splitAttemptsNum.charAt(0) || ASCIININE < splitAttemptsNum.charAt(0)) {
            return false;
        }

        return true;
    }

    private static boolean canMove() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        System.out.println("randomNum " + Integer.toString(randomNum));

        if (isInMoveRange(randomNum)) {
            return true;
        }

        return false;
    }

    private static boolean isInMoveRange(final int randomNum) {
        if (randomNum >= MOVE_NUMBER) {
            return true;
        }

        return false;
    }
}
