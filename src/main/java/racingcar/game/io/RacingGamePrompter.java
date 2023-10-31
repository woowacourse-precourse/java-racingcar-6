package racingcar.game.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class RacingGamePrompter {

    protected static List<String> promptNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return parseNames(Console.readLine());
    }

    private static List<String> parseNames(String input) {
        List<String> splitInput = List.of(input.split(","));

        if (splitInput.stream().noneMatch(w -> w.length() > 5)) {
            return splitInput;
        } else {
            throw new IllegalArgumentException("Name should be shorter than 6");
        }
    }

    protected static Integer promptRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        return parseInt(Console.readLine());
    }

    private static Integer parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("User input is not integer");
        }
    }
}
