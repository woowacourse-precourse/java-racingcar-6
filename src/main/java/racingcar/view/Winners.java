package racingcar.view;

import static java.lang.String.join;

import java.util.List;

public class Winners {
    public static void showWinners(List<String> winners) {
        System.out.print("최종 우승자 : " + makeString(winners));
    }

    static String makeString(List<String> winners) {
        String str = join(", ", winners);
        return str;
    }
}
