package racingcar.utils.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

/**
 * 사용자 이름 입력
 */
public class UsernameInputManager implements InputManager<List<String>> {
    private static final UsernameInputManager INSTANCE = new UsernameInputManager();

    private UsernameInputManager() {
    }

    public static UsernameInputManager getInstance() {
        return INSTANCE;
    }

    public List<String> input() {
        String input = Console.readLine();
        return validateNames(input);
    }

    public List<String> validateNames(String input) {
        if (input == null || input.isEmpty()) throw new IllegalArgumentException();

        List<String> validatedNames = Arrays.stream(input.split(","))
                .map(String::trim)
                .peek(name -> {
                    if (name.isEmpty() || name.length() > 5) throw new IllegalArgumentException();
                }).toList();

        if (validatedNames.isEmpty()) throw new IllegalArgumentException();

        return validatedNames;
    }
}
