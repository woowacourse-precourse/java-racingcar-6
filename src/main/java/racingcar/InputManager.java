package racingcar;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    public static String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)로 구분)");
        String input = Console.readLine();
        validateCarNames(input);
        return input.split(",");
    }

    public static int getNumberOfAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        int numberOfAttempts = parseNumberOfAttempts(Console.readLine());
        validateNumberOfAttempts(numberOfAttempts);
        return numberOfAttempts;
    }

    public static List<Car> initializeCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private static void validateCarNames(String input) {
        String[] carNames = input.split(",");
        Set<String> nameSet = new HashSet<>();

        for (String carName : carNames) {
            if (carName.isEmpty() || carName.contains(" ") || carName.length() < 1 || carName.length() > 5 || nameSet.contains(carName)) {
                throw new IllegalArgumentException("자동차 이름을 확인하세요.");
            }
            nameSet.add(carName);
        }
    }

    private static int parseNumberOfAttempts(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자를 입력하세요.");
        }
    }

    private static void validateNumberOfAttempts(int numberOfAttempts) {
        if (numberOfAttempts <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }
}
