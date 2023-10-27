package view.inputView;


import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class ConsoleInputView implements InputView {
    public List<String> readCarNames() {
        String input = Console.readLine();
        String[] carNames = input.split(",");
        return Arrays.stream(carNames)
                .toList();
    }
}
