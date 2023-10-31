package racingcar.view;

import java.util.List;
import racingcar.model.CarDto;
import racingcar.model.ScoreBoard;

public class OutputView {
    private static final String BEFORE_RACE_MESSAGE = "실행 결과";

    public static void beforeRaceMessage() {
        printEmptyLine();
        System.out.println(BEFORE_RACE_MESSAGE);
    }

    public static void showScoreBoard(ScoreBoard scoreBoard) {
        StringBuilder stringBuilder = new StringBuilder("");
        for (int round = 1; round <= scoreBoard.getSize(); round++) {
            List<CarDto> score = scoreBoard.getScoreForRound(round);
            for (CarDto carDto : score) {
                stringBuilder.append(carDto.getName())
                        .append(" : ")
                        .append("-".repeat(carDto.getDistance()))
                        .append("\n");
            }
            stringBuilder.append("\n");
        }
        System.out.print(stringBuilder);
    }

    private static void printEmptyLine() {
        System.out.println();
    }

}
