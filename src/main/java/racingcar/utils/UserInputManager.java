package racingcar.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInputManager {
    private static final int MAX_LENGTH = 5;

    public List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return parseCarNames(input);
    }

    public int inputAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    private List<String> parseCarNames(String input) {
        List<String> cars = Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(carName -> !carName.isEmpty())
                .collect(Collectors.toList());

        for (String car : cars) {
            validateUserInput(car);
        }

        return cars;
    }

    public void validateUserInput(String car) {
        if (car.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 5자 이하만 가능합니다.");
        }
    }
}


