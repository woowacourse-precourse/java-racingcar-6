package racingcar.view;

import java.util.List;

public class OutputView {
    // List<String> 형태로 값을 입력하면
    // 화면에 출력하는 메서드
    public static void printResult(List<String> resultList) {
        for (String result : resultList) {
            System.out.println(result);
        }
    }

    public static void printResult(String result) {
        System.out.println(result);
    }
}
