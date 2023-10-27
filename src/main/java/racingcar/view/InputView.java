package racingcar.view;

import static java.lang.Integer.parseInt;

public class InputView {

    public String readCarNames() {
        return readLine();
    }

    public int readAttempt() {
        return parseInt(readLine());
    }

    public static String readLine() {
        return camp.nextstep.edu.missionutils.Console.readLine();
    }
}
