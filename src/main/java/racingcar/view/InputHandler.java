package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputHandler {

    private static final int MAX_NAME_LENGTH = 5;

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> names = Arrays.asList(Console.readLine().split(","));
        validateCarNames(names);
        return names;
    }

    public static int getAttemptCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            int attempts = Integer.parseInt(Console.readLine());
            if (attempts < 1) {
                throw new IllegalArgumentException("시도할 회수는 1회 이상이어야 합니다.");
            }
            return attempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 회수는 숫자로 입력해야 합니다.");
        }
    }

    private static void validateCarNames(List<String> names) {
        for (String name : names) {
            if (name.length() < 1 || name.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상, " + MAX_NAME_LENGTH + "자 이하로 입력해야 합니다.");
            }
        }
    }
}
