package racingcar.view;

import java.util.List;

public class Winners {
    public static void showWinners(List<String> winners) {
        System.out.print("최종 우승자 : " + makeString(winners));
    }

    static String makeString(List<String> winners) {
        String str = String.join(", ", winners);
        return str;
    }
}
