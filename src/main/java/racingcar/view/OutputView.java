package racingcar.view;

import racingcar.model.RacingCar;

import java.util.List;

public class OutputView {
    private static final String RESULT_START_MESSAGE = "실행 결과";

    public void printRacingCar(final RacingCar racingCar) {
        String racingCarName = racingCar.getName();
        int racingCarPosition = racingCar.getPosition();

        System.out.println(racingCarName + " : " + "-".repeat(racingCarPosition));
    }

    public void printMessageStartResult() {
        System.out.println();
        System.out.println(RESULT_START_MESSAGE);
    }

    public void printWinners(final List<String> winners) {
        String output = String.join(", ", winners);

        System.out.println("최종 우승자 : " + output);
    }
}
