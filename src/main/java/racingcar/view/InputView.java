package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.view.InputMessage.*;

public class InputView {
    public static String readInput(String question) {
        System.out.println(question);
        return readLine();
    }

    public static String readPlayer() {
        System.out.println(CAR_NAME_INPUT.getInputMessage());
        return readLine();
    }

    public static String readTotalRound() {
        System.out.println(HOW_MANY_ROUND_INPUT.getInputMessage());
        return readLine();
    }



}
