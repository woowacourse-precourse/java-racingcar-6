package racingcar.view;

import java.util.List;

public class OutputView {
    public void divideLine () {
        System.out.println();
    }
    public void result() {
        System.out.println("\n실행 결과");
    }
    public void resultByRound(String name, String printDistance) {
        System.out.printf("%s : %s\n", name, printDistance);
    }
    public void winner(String winnerNames) {
        System.out.printf("최종 우승자 : %s", winnerNames);
    }
}
