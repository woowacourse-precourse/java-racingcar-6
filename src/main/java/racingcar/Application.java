package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        playRacingGame();
    }

    private static void playRacingGame() {
        List<Car> cars = createCars(getCarNames(getInputLineOfCarNames()));
        int numberOfAttempts = getNumberOfAttempts();
        printHeadResult();
        attempt(cars,numberOfAttempts);
        printWinner(cars);
    }
    private static void attempt(List<Car> cars, int numberOfAttempts){
        for (int i = 0; i < numberOfAttempts; i++) {
            attemptOneRound(cars);
            printOneRoundResult(cars);
        }
    }

    private static String getInputLineOfCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return validateInputLineOfCarNames(Console.readLine());
    }

    private static String validateInputLineOfCarNames(String inputLineOfCarNames) {
        if (inputLineOfCarNames.startsWith(",") || inputLineOfCarNames.endsWith(",")) {
            throw new IllegalArgumentException("입력 형식이 맞지 않습니다.");
        }
        return inputLineOfCarNames;
    }

    private static List<String> getCarNames(String inputLineOfCarNames) {
        return checkCarNames(splitCarNames(inputLineOfCarNames));
    }

    private static List<String> splitCarNames(String inputLineOfCarNames) {
        return Arrays.asList(inputLineOfCarNames.split(","));
    }

    private static List<String> checkCarNames(List<String> carNames) {
        checkCarNameForm((carNames));
        validateDuplicateOfCarName((carNames));
        return carNames;
    }

    private static void checkCarNameForm(List<String> carNames) {
        carNames.forEach(carName -> {
            validateCarNameRegex(carName);
            validateMaxLengthOfCarName(carName);
        });
    }

    private static void validateCarNameRegex(String carName) {
        String regex = "^[a-zA-Z]+[a-zA-Z0-9]*$";
        if (!Pattern.matches(regex, carName)) {
            throw new IllegalArgumentException("이름 형식이 맞지 않습니다.");
        }
    }

    private static void validateMaxLengthOfCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("이름 길이가 초과했습니다.");
        }
    }

    private static void validateDuplicateOfCarName(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<String>();
        carNames.forEach(carName -> {
            if (!uniqueNames.add(carName)) {
                throw new IllegalStateException("이름이 중복됩니다.");
            }
        });
    }

    private static List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private static int getNumberOfAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(checkNumberOfAttemptsForm(Console.readLine()));
    }

    private static String checkNumberOfAttemptsForm(String numberOfAttempts) {
        validateIsNumber(numberOfAttempts);
        validateIsZero(numberOfAttempts);
        return numberOfAttempts;
    }

    private static void validateIsNumber(String numberOfAttempts) {
        String numberRegex = "^[0-9]*$";
        if (!Pattern.matches(numberRegex,numberOfAttempts)) {
            throw new IllegalArgumentException("숫자 형식이 아닙니다.");
        }
    }

    private static void validateIsZero(String numberOfAttempts) {
        if (Pattern.matches("0",numberOfAttempts)) {
            throw new IllegalArgumentException("0은 입력할 수 없습니다.");
        }
    }

    private static void printHeadResult() {
        System.out.println("\n실행 결과");
    }

    private static void attemptOneRound(List<Car> cars) {
        cars.forEach(car -> {
            if (isMove()) {
                car.moveForward();
            }
        });
    }

    private static boolean isMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }

    private static void printOneRoundResult(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.toString()));
        System.out.println();
    }

    private static List<String> findWinner(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        List<String> winner = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
        return winner;
    }

    private static int findMaxPosition(List<Car> cars) {
        int maxPosition = -1;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    private static void printWinner(List<Car> cars) {
        List<String> winner = findWinner(cars);
        String result = String.join(",", winner);
        System.out.println(String.format("최종 우승자 : %s", result));
    }
}
