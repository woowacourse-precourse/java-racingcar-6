package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    private static int ASCII_ZERO = 48;
    private static int ASCII_NINE = 57;
    private static int MOVE_NUMBER = 4;

    public static class Car {

        String carName;
        int location;

        Car(final String carName) {
            this.carName = carName;
            this.location = 0;
        }

        public String getCarName() {
            return this.carName;
        }

        public void move() {
            this.location++;
        }

        public int getLocation() {
            return this.location;
        }
    }

    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        printInputCarNameMessage();
        String[] carNames = inputCarNames();
        printInputAttemptsNumMessage();
        int attemptsNum = inputAttemptsNum();

        List<Car> cars = createCars(carNames);

        printExecuteResultMessage();
        repeatAttempts(attemptsNum, cars);
        printWinners(cars);
    }

    public static void printInputCarNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printInputAttemptsNumMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printExecuteResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printWinners(final List<Car> cars) {
        List<String> winnerCarNames = getWinners(cars);
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winnerCarNames));
    }

    public static List<String> getWinners(final List<Car> cars) {
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

    public static void printCarStatus(final List<Car> cars) {
        for (Car car : cars) {
            printCarName(car);
            printCurrentLocation(car);
        }
    }

    public static void printCurrentLocation(final Car car) {
        int location = car.getLocation();
        StringBuilder locationStringBuilder = new StringBuilder();

        for (int i = 0; i < location; i++) {
            locationStringBuilder.append("-");
        }

        System.out.println(locationStringBuilder);
    }

    public static void printCarName(final Car car) {
        System.out.print(car.getCarName() + " : ");
    }

    public static void repeatAttempts(final int attemptsNum, final List<Car> cars) {
        for (int i = 0; i < attemptsNum; i++) {
            moveCars(cars);
            printCarStatus(cars);
            System.out.println();
        }
    }

    public static List<Car> createCars(final String[] carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }

    public static void moveCars(final List<Car> cars) {
        for (Car car : cars) {
            if (canMove()) {
                car.move();
            }
        }
    }

    public static String[] inputCarNames() {
        String[] carNames = Console.readLine().split(",");

        if (!validateCarNames(carNames)) {
            throw new IllegalArgumentException("잘못된 자동차 이름이 포함되어 있습니다.");
        }

        return carNames;
    }

    public static int inputAttemptsNum() {
        String attemptsNum = Console.readLine();

        if (!validateAttemptsNum(attemptsNum)) {
            throw new IllegalArgumentException("잘못된 시도 횟수 입니다.");
        }

        return Integer.parseInt(attemptsNum);
    }

    public static boolean validateCarNames(final String[] carNames) {
        for (String carName : carNames) {
            if (!validateCarNameLength(carName) || !checkSameCarName(carNames)) {
                return false;
            }
        }

        return true;
    }

    public static boolean validateCarNameLength(final String carName) {
        if (carName.length() > 5) {
            return false;
        }

        return true;
    }

    public static boolean checkSameCarName(final String[] carNames) {
        List<String> carNameList = Arrays.asList(carNames);
        if(carNameList.size() != carNameList.stream().distinct().count()){
            return false;
        }

        return true;
    }

    public static boolean validateAttemptsNum(final String attemptsNum) {
        if (!validateAttemptsNumIsNumber(attemptsNum) || !validateAttemptsNumIsZero(attemptsNum)) {
            return false;
        }

        return true;
    }

    public static boolean validateAttemptsNumIsNumber(final String attemptsNum) {
        String[] splitAttemptsNums = attemptsNum.split("");

        for (String splitAttemptsNum : splitAttemptsNums) {
            if (!isNumber(splitAttemptsNum)) {
                return false;
            }
        }

        return true;
    }

    public static boolean validateAttemptsNumIsZero(final String attemptsNum) {
        int intAttemptsNum = Integer.parseInt(attemptsNum);

        if (intAttemptsNum == 0) {
            return false;
        }

        return true;
    }

    public static boolean isNumber(final String splitAttemptsNum) {
        if(ASCII_ZERO > splitAttemptsNum.charAt(0) || ASCII_NINE < splitAttemptsNum.charAt(0)) {
            return false;
        }

        return true;
    }

    public static boolean canMove() {
        int randomNum = Randoms.pickNumberInRange(0, 9);

        if (isInMoveRange(randomNum)) {
            return true;
        }

        return false;
    }

    public static boolean isInMoveRange(final int randomNum) {
        if (randomNum >= MOVE_NUMBER) {
            return true;
        }

        return false;
    }
}
