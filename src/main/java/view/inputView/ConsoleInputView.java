package view.inputView;


import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class ConsoleInputView implements InputView {
    private static final String NOT_NUMBER_MESSAGE = "숫자를 입력하세요.";

    @Override
    public List<String> readCarNames() {
        String input = Console.readLine();
        String[] carNames = input.replace(" ", "")
                .split(",");
        return Arrays.stream(carNames)
                .toList();
    }

    @Override
    public int readAttempt() {
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_MESSAGE);
        }
    }
}
