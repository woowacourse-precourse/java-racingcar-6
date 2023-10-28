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

    public static void printOperateResult(List<LinkedHashMap<String, Integer>> operateResults) {
        printNoticeMessage(OPERATE_RESULT);
        StringBuilder sb = new StringBuilder();

        operateResults.forEach((operateResult) -> {
            for (Entry<String, Integer> entry : operateResult.entrySet()) {
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

    public static void printChampions(List<String> champions) {
        printNoticeMessage(CHAMPION);
        String result = String.join(", ", champions);
        System.out.println(result);
    }

    public static void newLine() {
        System.out.println();
    }
}
