package racingcar.view;

import java.util.List;
import racingcar.system.SystemMessage;

public class OutputHandler {
    public static void printRaceProgressLabel() {
        System.out.print(SystemMessage.RACE_RESULT.getMessage());
    }

    public static void printRaceProgress(List<String> raceResult) {
        raceResult.forEach(System.out::println);
        System.out.println();
    }

    public static void printFinalWinner(String winnerListString) {
        System.out.print(SystemMessage.FINAL_WINNER.getMessage() + winnerListString);
    }


}
