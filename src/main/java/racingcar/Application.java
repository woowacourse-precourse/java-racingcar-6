package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

import racingcar.Car;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(getNumberOfAttempts());
    }

    private static void printInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    private static String getCarNames() {
        printInputCarNames();
        String inputLineOfCarNames = Console.readLine();
        checkInputLineCarNames(inputLineOfCarNames);
        return inputLineOfCarNames;
    }

    private static List<String> saveCarNames(String inputLineOfCarNames) {
        List<String> carNames = Arrays.asList(inputLineOfCarNames.split(","));
        checkCarNameForm((carNames));
        checkDuplicateOfCarName((carNames));
        return carNames;
    }

    private static String checkInputLineCarNames(String inputLineOfCarNames) {
        checkStartWithInputLine(inputLineOfCarNames);
        checkLastIndexInputLine(inputLineOfCarNames);
        return inputLineOfCarNames;
    }

    private static void checkStartWithInputLine(String inputLineOfCarNames) {
        if (inputLineOfCarNames.startsWith(",")) {
            throw new IllegalArgumentException("입력 형식이 맞지 않습니다.");
        }
    }

    private static void checkLastIndexInputLine(String inputLineOfCarNames) {
        if (inputLineOfCarNames.lastIndexOf(",") == inputLineOfCarNames.length() - 1) {
            throw new IllegalArgumentException("입력 형식이 맞지 않습니다.");
        }
    }

    private static void checkCarNameForm(List<String> carNames) {
        for (String carName : carNames) {
            checkCarNameRegex(carName);
            checkMaxLengthOfCarName(carName);
        }
    }

    private static void checkCarNameRegex(String carName) {
        String regex = "^[a-zA-Z]+[a-zA-Z0-9]*$";
        if (!carName.matches(regex)) {
            throw new IllegalArgumentException("이름 형식이 맞지 않습니다.");
        }
    }

    private static void checkMaxLengthOfCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("이름 길이가 초과했습니다.");
        }
    }

    private static void checkDuplicateOfCarName(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<String>();
        for (String carName : carNames) {
            if (!uniqueNames.add(carName)) {
                throw new IllegalStateException("이름이 중복됩니다.");
            }
        }
    }

    private static List<Car> makeCars(List<String> carNames) {
        List<Car> cars = new ArrayList<Car>();
        for (int i = 0; i < carNames.size(); i++) {
            Car car = new Car(carNames.get(i));
            cars.add(car);
        }
        return cars;
    }

    private static void printInputNumberofAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    private static int getNumberOfAttempts() {
        printInputNumberofAttempts();
        int numberOfAttempts = Integer.parseInt(checkNumberOfAttemptsForm(Console.readLine()));
        return numberOfAttempts;
    }

    private static String checkNumberOfAttemptsForm(String numberOfAttempts) {
        checkIsNumber(numberOfAttempts);
        checkIsZero(numberOfAttempts);
        return numberOfAttempts;
    }
    private static void checkIsZero(String numberOfAttempts){
        if(numberOfAttempts.matches("0")){
            throw new IllegalArgumentException("0은 입력할 수 없습니다.");
        }
    }
    private static void checkIsNumber(String numberOfAttempts){
        String numberRegex = "^[0-9]*$";
        if(!numberOfAttempts.matches(numberRegex)){
            throw new IllegalArgumentException("숫자 형식이 아닙니다.");
        }
    }

}
