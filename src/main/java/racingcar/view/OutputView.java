package racingcar.view;

import static racingcar.domain.Constant.MINUMUN_DISTANCE;

import java.util.List;
import racingcar.dto.MoveResultDto;

public class OutputView {
    private static final String MOVE_RESULT_MESSAGE = "실행 결과";
    private static final String PLAYER_MOVE_MESSAGE = "%s : %s";
    private static final String WINNER_MESSAGE = "최종 우승자 : %s";


    public static void printMoveResult(final List<MoveResultDto> moveResultDtoList) {
        for (MoveResultDto moveResult : moveResultDtoList) {
            String playerName = moveResult.getPlayerName();
            String movement = getMovement(moveResult);
            System.out.printf(PLAYER_MOVE_MESSAGE, playerName, movement);
            printEmptyLine();
        }
        printEmptyLine();
    }

    private static String getMovement(MoveResultDto moveResult) {
        int distance = moveResult.getDistance();
        return "-".repeat(Math.max(MINUMUN_DISTANCE, distance));
    }

    public static void printMoveResultMessage() {
        System.out.println(MOVE_RESULT_MESSAGE);
    }

    public static void printWinner(final List<String> winnerList) {
        String winnersName = String.join(", ", winnerList);
        System.out.printf(WINNER_MESSAGE, winnersName);
    }

    public static void printEmptyLine() {
        System.out.println();
    }
}
