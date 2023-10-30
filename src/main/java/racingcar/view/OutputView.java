package racingcar.view;

import racingcar.model.RacingCar;
import racingcar.model.RacingCars;

import java.util.List;

public class OutputView {
    private static final String RESULT_START_MESSAGE = "실행 결과";

    public void printMessageStartResult() {
        System.out.println();
        System.out.println(RESULT_START_MESSAGE);
    }

    public void printPositions(final RacingCars racingCars) {
        List<String> names = racingCars.getNames();
        List<Integer> positions = racingCars.getPositions();

        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i) + " : " + "-".repeat(positions.get(i)));
        }
    }

    public void printWinners(final List<String> winners) {
        String output = String.join(", ", winners);

        System.out.println("최종 우승자 : " + output);
    }
}
