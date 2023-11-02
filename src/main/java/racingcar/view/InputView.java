package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public static String askCarNames() {
        OutputView.printInputCarNameMessage();
        return readLine();
    }

    public static String askTriesCount() {
        OutputView.printInputTriesCountMessage();
        return readLine();
    }
}
