package racingcar.view;

import java.util.List;

public class OutputView {

    public static void responseExecution() {
        System.out.println("실행 결과");
    }

    public static void responseWinner(List<String> carNames, List<Integer> carPresentPoint) {
        int max = Integer.MIN_VALUE;
        String answer = "";
        for (int i = 0; i < carPresentPoint.size(); i++) {
            max = Math.max(max, carPresentPoint.get(i));
        }

        for (int i = 0; i < carNames.size(); i++) {
            if (carPresentPoint.get(i) == max) {
                answer += carNames.get(i);
                answer += ", ";
            }
        }

        System.out.println("최종 우승자 : " + answer);

    }
}
