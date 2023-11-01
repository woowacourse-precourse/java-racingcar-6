package racingcar.view;

import java.util.List;

public class OutputView {

    public static void outputRunResult() {
        System.out.println("실행 결과");
    }

    public static void outputCarRunResult(String carName, Integer advanceCount) {
        System.out.println(carName + " " + ":" + " " + "-".repeat(advanceCount));
    }

    public static void outputFinalWinner(List<String> winnerList) {
        String output = "최종 우승자 : ";
        String winner = String.join(", ", winnerList);

        System.out.println(output + winner);
    }
}
