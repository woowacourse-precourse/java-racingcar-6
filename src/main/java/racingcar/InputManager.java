package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.exception.NotIntegerException;

public class InputManager {
    public List<String> getCarNames() {
        String input = Console.readLine();
        String[] splited = input.split(",");
        return List.of(splited);
    }

    public int getRaceCount() {
        String input = Console.readLine();
        verifyInteger(input);
        return Integer.parseInt(input);
    }

    private static void verifyInteger(String input) {
        if (!input.chars().allMatch(Character::isDigit)) {
            throw new NotIntegerException();
        }
    }
}
