package racingcar.view;

import java.util.List;
import racingcar.dto.MoveResultDto;

public class OutputView {
    public static void printMoveResult(final List<MoveResultDto> moveResultDtoList) {
        for (MoveResultDto moveResult : moveResultDtoList) {
            String playerName = moveResult.getPlayerName();
            int distance = moveResult.getDistance();
            String moving = "-".repeat(Math.max(0, distance));
            System.out.printf("%s : %s", playerName, moving);
            printEmptyLine();
        }
        printEmptyLine();
    }

    private static void printEmptyLine() {
        // 이거 인풋, 아웃풋 중복 제거 필요@
        System.out.println();
    }

    public static void printMoveResultMessage() {
        System.out.println("실행 결과");
    }

    public static void printWinner(final List<String> winnerList) {
        String winnersName = String.join(", ", winnerList);
        System.out.printf("최종 우승자 : %s", winnersName);
    }
}
