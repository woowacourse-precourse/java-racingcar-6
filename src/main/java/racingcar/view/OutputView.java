package racingcar.view;

import java.util.List;

public class OutputView {

    public static void outputRunResult(String carName, Integer advanceCount) {
        System.out.println("실행 결과");
    }

    public static void outputCarRunResult(String carName, Integer advanceCount) {
        System.out.println(carName + " " + ":" + " " + "-".repeat(advanceCount));
    }

    public static void outputFinalWinner(List<String> winnerList) {
        String output = "최종 우승자 :";
        for(int i = 0; i < winnerList.size(); i++) {
            if(i == winnerList.size() - 1) {
                output += " " + winnerList.get(i);
            } else {
              output += " " + winnerList.get(i) + ",";
            }
        }
        System.out.println(output);
    }
}
