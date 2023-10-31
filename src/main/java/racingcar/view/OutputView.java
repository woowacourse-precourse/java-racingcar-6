package racingcar.view;

import static racingcar.global.GameConfig.MOVE_SYMBOL;
import static racingcar.view.constants.NoticeMessage.CHAMPION;
import static racingcar.view.constants.NoticeMessage.OPERATE_RESULT;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import racingcar.view.constants.NoticeMessage;

public class OutputView {
    public static void printNoticeMessage(NoticeMessage noticeMessage) {
        System.out.print(noticeMessage.getMessage());
    }

    public static void printAttempts(List<LinkedHashMap<String, Integer>> attempts) {
        printNoticeMessage(OPERATE_RESULT);
        StringBuilder sb = new StringBuilder();

        attempts.forEach((attempt) -> {
            for (Entry<String, Integer> entry : attempt.entrySet()) {
                String carName = entry.getKey();
                Integer move = entry.getValue();

                sb.append(String.format("%s : ", carName));
                while (move-- > 0) {
                    sb.append(MOVE_SYMBOL);
                }
                sb.append("\n");
            }

            sb.append("\n");
        });

        System.out.print(sb);
    }

    public static void printWinners(List<String> winners) {
        printNoticeMessage(CHAMPION);
        String result = String.join(", ", winners);
        System.out.println(result);
    }

    public static void newLine() {
        System.out.println();
    }
}
