package racingcar.view.input;

import java.util.List;

public class MainInputView {

    private MainInputView() {
    }

    public static List<String> readCarNames() {
        Input input = Input.readLine();
        String trimmedInput = input.trimmed();

        return CarNamesInput.parse(trimmedInput).carNames();
    }

    public static int readPlayCount() {
        Input input = Input.readLine();
        String trimmedInput = input.trimmed();

        return PlayCountInput.parse(trimmedInput).playCount();
    }
}
