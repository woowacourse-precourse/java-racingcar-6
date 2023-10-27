package racingcar.view;

import static java.lang.Integer.parseInt;
import static racingcar.utils.Console.readLine;

public class InputView {

    public String readCarNames() {
        return readLine();
    }

    public int readAttempt() {
        try {
            return parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
