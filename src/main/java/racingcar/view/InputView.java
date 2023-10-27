package racingcar.view;

import static java.lang.Integer.parseInt;

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

    public static String readLine() {
        return camp.nextstep.edu.missionutils.Console.readLine();
    }
}
