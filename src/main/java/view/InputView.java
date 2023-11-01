package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputView {
    private final static int MAX_LENGTH_CAR = 5;
    public static List<String> inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        validateCarNames(input);
        List<String> carNames = List.of(input.split(","));
        return carNames;
    }

    private static void validateCarNames(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈 값이 될 수 없습니다.");
        }
        List<String> carNames = List.of(input.split(","));

        for (String carName : carNames) {
            if (carName.length() > MAX_LENGTH_CAR) {
                throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
            }
        }
    }

    public static int inputNumberOfTrials() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        return Integer.parseInt(input);
    }
}
