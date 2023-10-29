package racingcar.view.input;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.contant.GameNotice.GAME_START;
import static racingcar.contant.GameNotice.ROUND_NUMBER;
import static racingcar.view.output.OutputView.printGameNotice;

public class InputView {
    public static String inputCarName() {
        printGameNotice(GAME_START);
        return readLine();
    }

    public static String inputRoundNumber() {
        printGameNotice(ROUND_NUMBER);
        return readLine();
    }

}
