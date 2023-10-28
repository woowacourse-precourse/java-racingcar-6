package racingcar.view;

import java.util.List;

public class OutputView {
    public static void printExecResult() {
        System.out.println("실행 결과");
    }
    public static void printWinner(List<String> winnerName) {
        int winnerSize = winnerName.size();
        System.out.print("최종 우승자 : ");
        for(int i = 0; i < winnerSize - 1; i++) {
            System.out.print(winnerName.get(i));
            System.out.print(", ");
        }
        System.out.println(winnerName.get(winnerSize - 1));
    }
}
