package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.view.constants.Notice.ASK_ATTEMPT_NUMBER;
import static racingcar.view.constants.Notice.ASK_CAR_NAME;

public class InputView {
    public static String askCarName(){
        System.out.println(ASK_CAR_NAME);
        return readLine();
    }
}
