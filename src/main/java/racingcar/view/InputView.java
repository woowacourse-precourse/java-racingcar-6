package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.view.constants.NoticeMessage.ASK_CAR_NAME;
import static racingcar.view.constants.NoticeMessage.ASK_NUMBER_OF_ATTEMPTS;

public class InputView {
    public static String askCarNames(){
        OutputView.printNoticeMessage(ASK_CAR_NAME);
        return readLine();
    }

    public static String askNumberOfAttempts(){
        OutputView.printNoticeMessage(ASK_NUMBER_OF_ATTEMPTS);
        return readLine();
    }
}
