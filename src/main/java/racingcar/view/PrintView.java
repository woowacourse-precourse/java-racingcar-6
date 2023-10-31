package racingcar.view;

import java.util.ArrayList;
import racingcar.constant.Message;
import racingcar.util.FormatUtil;

public class PrintView {
    public static void inputCarNamesMessage() {
        System.out.println(Message.INPUT_CAR_NAME.getMessage());
    }

    public static void inputStageTimesMessage() {
        System.out.println(Message.INPUT_STAGE_TIME.getMessage());
    }

    public static void initialStageResultMessage() {
        System.out.println(Message.PRINT_STAGE_RESULT.getMessage());
    }

    public static void stageResultMessage(ArrayList<String> list) {
        for (String result : list) {
            System.out.println(result);
        }
        System.out.println();
    }

    public static void winnerResultMessage(ArrayList<String> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append(Message.PRINT_WINNER.getMessage());
        sb.append(FormatUtil.winnerResultFormat(winners));
        System.out.println(sb);
    }
}
