package racingcar.view;

import racingcar.model.RacingCars;

import java.util.List;

public class OutputView {
    private static final String RESULT_START_MESSAGE = "실행 결과";

    public void printMessageStartResult() {
        System.out.println();
        System.out.println(RESULT_START_MESSAGE);
    }

    public void printPositions(final RacingCars racingCars) {
        List<String> positions = racingCars.getPositions();

        for (String position : positions) {
            System.out.println(position);
        }

        System.out.println();
    }

    public void printWinners(final List<String> winners) {
        String output = String.join(", ", winners);

        System.out.println("최종 우승자 : " + output);
    }
}
