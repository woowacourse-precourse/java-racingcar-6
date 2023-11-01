package racingcar.view;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final int MAX_NAME_LENGTH = 5;

    public static String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return splitCarNames(Console.readLine());
    }

    public static int inputNumberOfCarsMoving() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        validateNumberOfCarsMoving(input);
        return Integer.parseInt(input);
    }

    public static void validateNumberOfCarsMoving(String input) {
        List<String> transferInputToStringList = Arrays.asList(input.split(""));
        transferInputToStringList.forEach(InputView::validateIsStringNumber);
    }

    private static void validateIsStringNumber(String input) {
        int value = Integer.parseInt(input);
        if (value >= 0 && value <= 9) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
    }

    private static String[] splitCarNames(String input) {
        String[] names = input.split(",");
        for (String name : names) {
            validateNameFormat(name);
        }
        validateDuplicateNames(names);
        return names;
    }

    private static void validateNameFormat(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름이 5글자를 초과합니다.");
        }
    }

    private static void validateDuplicateNames(String[] names) {
        HashSet<String> tempSet = new HashSet<>(Arrays.asList(names));
        if (names.length != tempSet.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 이름이 존재합니다.");
        }
    }
}