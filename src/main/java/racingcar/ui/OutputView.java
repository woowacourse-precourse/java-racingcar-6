package racingcar.ui;

import java.util.List;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    public void outputStep(List<String> moveResultList) {
        System.out.println();
        System.out.println(RESULT_MESSAGE);

        moveResultList.stream().forEach(result -> {
            System.out.println(result);
            System.out.println();
        });
    }

    public void outputWinner(String winners) {
        System.out.printf(WINNER_MESSAGE);
        System.out.println(winners);
    }
}
