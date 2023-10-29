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
    private final static String POSITION_UNIT = "-";

    public ResultViewer(RacingManager racingManager) {
        this.racingManager = racingManager;
    }

    public void printResult() {
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
        String carName = car.name();
        int currentPosition = car.position();

        StringBuilder builder = new StringBuilder()
                .append(carName)
                .append(" : ");

        for (int i = 0; i < currentPosition; ++i) {
            builder.append(POSITION_UNIT);
        }

        return builder.toString();
    }

    public void printWinner() {
        List<String> winnerCarName = racingManager.getWinnerName();
        String winnerJoinList = String.join(", ", winnerCarName);

        System.out.println("최종 우승자 : " + winnerJoinList);
    }
}