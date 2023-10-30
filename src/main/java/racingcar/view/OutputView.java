package racingcar.view;

import java.util.List;

public class OutputView {

    private static final String COMMA = ",";

    public void printRacingStart() {
        System.out.println("\n실행 결과");
    }

    public void printWinner(List<String> winner) {
        System.out.println("최종 우승자 : " + String.join(COMMA, winner));
    }
}
