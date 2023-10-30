package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.view.OutputView.printSystemMessage;
import static racingcar.view.SystemMessage.ASK_CAR_LIST;
import static racingcar.view.SystemMessage.ASK_NUM_OF_MATCHES;

public class InputView {
    public static String askCarList() {
        printSystemMessage(ASK_CAR_LIST);
        return readLine();
    }

    public static String askNumOfMatches() {
        printSystemMessage(ASK_NUM_OF_MATCHES);
        return readLine();
    }
}
