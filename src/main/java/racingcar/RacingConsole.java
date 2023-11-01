package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.records.RacingCarSnapshot;
import racingcar.records.RacingHistory;

import java.util.List;

public class RacingConsole {
    public static String getCarNamesInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public static String getMoveCountInput() {
        System.out.println("시도할 회수는 몇 회인가요?");
        return Console.readLine();
    }

    public static void printMoveResult(List<RacingHistory> racingResult) {
        System.out.println("\n실행 결과");
        racingResult.forEach(RacingConsole::printMoveResult);
    }

    private static void printMoveResult(RacingHistory history) {
        history.snapshots().forEach((RacingCarSnapshot racingSnapshot) -> {
            System.out.println(racingSnapshot.name() + " : " + "-".repeat(racingSnapshot.forwardCount()));
        });
        System.out.println();
    }

    public static void printRacingWinnerNames(List<String> winnerNames) {
        System.out.printf("최종 우승자 : %s", String.join(", ", winnerNames));
    }
}
