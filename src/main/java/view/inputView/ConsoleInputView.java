package view.inputView;


import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class ConsoleInputView implements InputView {
    private static final String NOT_NUMBER_MESSAGE = "숫자를 입력하세요.";
    public List<String> readCarNames() {
        String input = Console.readLine();
        String[] carNames = input.split(",");
        return Arrays.stream(carNames)
                .toList();
    }

    public int readAttempt() {
        String input = Console.readLine();
        try {
            int attempt = Integer.parseInt(input);
            return attempt;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
        }
    }
}
