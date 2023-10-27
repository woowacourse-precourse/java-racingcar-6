package racingcar.view;

import java.util.List;

public class OutputView {
    public void printFirstResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void printWinnerResult(String winner) {
        System.out.println("최종 우승자 : " + winner);
    }

    public void printJointWinnerResult(List<String> jointWinner) {
        String result = String.join(", ", jointWinner);
        System.out.println("최종 우승자 : " + result);
    }
}
