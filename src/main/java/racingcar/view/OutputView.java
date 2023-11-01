package racingcar.view;

import java.util.List;
import racingcar.dto.MoveResultDto;

public class OutputView {
    private static final String PRE_RESULT_MESSAGE = "실행 결과";

    public static void printMoveResult(final List<MoveResultDto> moveResultDtoList) {
        for (MoveResultDto moveResultDto : moveResultDtoList) {
            String playerName = moveResultDto.getPlayerName();
            String movement = getMovement(moveResultDto);
            System.out.printf("%s : %s", playerName, movement);
            printEmptyLine();
        }
        printEmptyLine();
    }

    private static String getMovement(MoveResultDto moveResultDto) {
        return "-".repeat(moveResultDto.getDistance());
    }

    public static void printPreResultMessage() {
        printEmptyLine();
        System.out.println(PRE_RESULT_MESSAGE);
    }

    public static void printWinners(final List<String> winnerList) {
        String winnersName = String.join(", ", winnerList);
        System.out.printf("최종 우승자 : %s", winnersName);
    }

    public static void printEmptyLine() {
        System.out.println();
    }
}
