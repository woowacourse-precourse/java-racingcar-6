package racingcar.view;

import java.util.List;

public class OutputView {
    public static void printResult(List<String> resultList) {
        for (String result : resultList) {
            System.out.println(result);
        }
    }

    public static void printResult(String result) {
        System.out.print(result);
    }
}
