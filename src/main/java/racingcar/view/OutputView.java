package racingcar.view;

import java.util.ArrayList;
import racingcar.enums.StringEnum;

public class OutputView {
    public void printCurrent(String name, int position) {
        StringBuilder result = new StringBuilder();

        result.append(name).append(" :");

        if (position > 0) {
            result.append(" ");
        }

        result.append(getProgressBar(position));

        System.out.println(result);
    }

    StringBuilder getProgressBar(int position) {
        StringBuilder s = new StringBuilder();
        return s.append("-".repeat(position));
    }

    public void printResult(ArrayList<String> winner) {
        String s = StringEnum.RESULT_STRING + String.join(", ", winner);
        System.out.println(s);
    }
}
