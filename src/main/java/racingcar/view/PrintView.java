package racingcar.view;

import java.util.ArrayList;
import racingcar.constant.Message;
import racingcar.util.ReturnUtil;

public class PrintView {
    public static void inputCarNamesMessage() {
        System.out.println(Message.INPUT_CAR_NAME);
    }

    public static void inputStageTimesMessage() {
        System.out.println(Message.INPUT_STAGE_TIME);
    }

    public static void stageResultMessage(ArrayList<String> list) {
        System.out.println(Message.PRINT_STAGE_RESULT);
        for (String result : list) {
            System.out.println(result);
        }
    }

    public static void winnerResultMessage(ArrayList<String> winners) {
        StringBuilder sb = new StringBuilder();
        sb.append(Message.PRINT_WINNER);
        sb.append(ReturnUtil.winnerResultFormat(winners));
        System.out.println(sb);
    }
}
