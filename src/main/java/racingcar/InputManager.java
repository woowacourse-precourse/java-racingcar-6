package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputManager {

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carNames = List.of(input.split(","));
        validateCarNames(carNames);
        return carNames;
    }

    private static void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    public static int getRounds() {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            String input = Console.readLine();
            int rounds = Integer.parseInt(input);
            validateRounds(rounds);
            return rounds;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도할 회수는 숫자만 가능합니다.");
        }
    }

    private static void validateRounds(int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException("시도할 회수는 양수만 가능합니다.");
        }
    }
}
