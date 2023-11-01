package racingcar.view;

import java.util.List;

public class RacingGameOutputView {
    public static void printWinners(List<String> winners) {
        StringBuilder sb = new StringBuilder("최종 우승자: ");
        for (int i = 0; i < winners.size(); i++) {
            sb.append(winners.get(i));
            if (i < winners.size() - 1) {
                sb.append(", ");
            }
        }
        System.out.println(sb.toString());
    }
}
