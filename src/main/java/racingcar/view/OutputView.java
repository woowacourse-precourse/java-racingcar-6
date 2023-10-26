package racingcar.view;

import java.util.ArrayList;
import racingcar.enums.TextEnum;

public class OutputView {
    public static void printCurrent(String name, int position) {

        String result = name + " : "
                + getProgressBar(position);

        System.out.println(result);
    }

    static StringBuilder getProgressBar(int position) {
        StringBuilder s = new StringBuilder();
        return s.append("-".repeat(position));
    }

    public static void printResult(ArrayList<String> winner) {
        String s = TextEnum.RESULT_TEXT + String.join(", ", winner);
        System.out.println(s);
    }
}
