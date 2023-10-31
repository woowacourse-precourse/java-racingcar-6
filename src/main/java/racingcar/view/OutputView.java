package racingcar.view;

import static racingcar.domain.Constant.MINUMUN_DISTANCE;

import java.util.List;
import racingcar.dto.PlayerMoveResultDto;

public class OutputView {
    private static final String MOVE_RESULT_MESSAGE = "실행 결과";
    private static final String PLAYER_MOVE_MESSAGE = "%s : %s";
    private static final String WINNER_MESSAGE = "최종 우승자 : %s";


    public static void printPlayerMoveResult(final List<PlayerMoveResultDto> playerMoveResultDtoList) {
        for (PlayerMoveResultDto playerMoveResult : playerMoveResultDtoList) {
            String playerName = playerMoveResult.getPlayerName();
            String movement = getMovement(playerMoveResult);
            System.out.printf(PLAYER_MOVE_MESSAGE, playerName, movement);
            printEmptyLine();
        }
        printEmptyLine();
    }

    private static String getMovement(PlayerMoveResultDto playerMoveResult) {
        int distance = playerMoveResult.getDistance();
        return "-".repeat(Math.max(MINUMUN_DISTANCE, distance));
    }

    public static void printMoveResultMessage() {
        System.out.println(MOVE_RESULT_MESSAGE);
    }

    public static void printWinners(final List<String> winnerList) {
        String winnersName = String.join(", ", winnerList);
        System.out.printf(WINNER_MESSAGE, winnersName);
    }

    public static void printEmptyLine() {
        System.out.println();
    }
}
