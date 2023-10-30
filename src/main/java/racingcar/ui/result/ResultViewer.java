package racingcar.ui.result;

import java.util.List;
import racingcar.racing.RacingManager;
import racingcar.racingcar.Car;

/**
 * @author 민경수
 * @description result viewer
 * @since 2023.10.29
 **********************************************************************************************************************/
public class ResultViewer {

    private final RacingManager racingManager;
    private final static String POSITION_INDICATOR = "-";

    public ResultViewer(RacingManager racingManager) {
        this.racingManager = racingManager;
    }

    public void printProgress() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printCurrentPositions() {
        this.racingManager.currentCarPositions()
                .stream()
                .map(this::generateCurrentPosition)
                .forEach(System.out::println);

        System.out.println();
    }

    private String generateCurrentPosition(Car car) {
        StringBuilder result = new StringBuilder()
                .append(car.name())
                .append(" : ");

        for (int i = 0; i < car.position(); ++i) {
            result.append(POSITION_INDICATOR);
        }

        return result.toString();
    }

    public void printWinner() {
        System.out.println("최종 우승자 : " + String.join(", ", racingManager.getWinnerName()));
    }
}