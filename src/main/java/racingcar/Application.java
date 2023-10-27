package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
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
        playGame();
    }

    private static void playGame() {
        printInputCarNameMessage();
        String[] carNames = inputCarNames();
        printInputAttemptsNumMessage();
        int attemptsNum = inputAttemptsNum();

        List<Car> cars = createCars(carNames);

        printExecuteResultMessage();
        repeatAttempts(attemptsNum, cars);
        printWinners(cars);
    }

    private static void printInputCarNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    private static void printInputAttemptsNumMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    private static void printExecuteResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    private static void printWinners(final List<Car> cars) {
        List<String> winnerCarNames = getWinners(cars);
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winnerCarNames));
    }

    private static List<String> getWinners(final List<Car> cars) {
        int maxLocation = 0;
        List<String> winnerCarNames = new ArrayList<>();

        for (Car car : cars) {
            int carLocation = car.getLocation();
            if (maxLocation < carLocation) {
                winnerCarNames.clear();
                maxLocation = carLocation;
                winnerCarNames.add(car.getCarName());
            }
            else if (maxLocation == carLocation) {
                winnerCarNames.add(car.getCarName());
            }
        }

        return winnerCarNames;
    }

    private static void printCarStatus(final List<Car> cars) {
        for (Car car : cars) {
            printCarName(car);
            printCurrentLocation(car);
        }
    }

    private static void printCurrentLocation(final Car car) {
        int location = car.getLocation();
        StringBuilder locationStringBuilder = new StringBuilder();

        for (int i = 0; i < location; i++) {
            locationStringBuilder.append("-");
        }

        System.out.println(locationStringBuilder);
    }

    private static void printCarName(final Car car) {
        System.out.print(car.getCarName() + " : ");
    }

    private static void repeatAttempts(final int attemptsNum, final List<Car> cars) {
        for (int i = 0; i < attemptsNum; i++) {
            moveCars(cars);
            printCarStatus(cars);
            System.out.println();
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
            throw new IllegalArgumentException("잘못된 자동차 이름이 포함되어 있습니다.");
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
            if (!validateCarNameLength(carName) || !checkSameCarName(carNames)) {
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

    private static boolean checkSameCarName(final String[] carNames) {
        List<String> carNameList = Arrays.asList(carNames);
        if(carNameList.size() != carNameList.stream().distinct().count()){
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
