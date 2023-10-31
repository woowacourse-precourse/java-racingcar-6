package racingcar.View;

import static racingcar.constant.Message.CYCLE_INPUT_MESSAGE;
import static racingcar.constant.Message.RACING_RESULT;
import static racingcar.constant.Message.START_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import racingcar.dto.RacingStatusDTO;
import java.util.List;

public class View {

    public static void printStartMessage() {
        System.out.println(START_MESSAGE.getMessage());
    }

    public static void printCycleInputMessage() {
        System.out.println(CYCLE_INPUT_MESSAGE.getMessage());
    }

    public static void printRacingResultMessage() {
        System.out.println("\n" + RACING_RESULT.getMessage());
    }

    public static void printRacingResult(List<List<RacingStatusDTO>> allRacingStatus) {
        for (List<RacingStatusDTO> statusPerRacing : allRacingStatus) {
            for (RacingStatusDTO racingStatus : statusPerRacing) {
                View.printMessage(racingStatus.toString());
            }
            View.printMessage("\n");
        }
    }

    public static void printMessage(String message) {
        System.out.print(message);
    }

    public static String input() {
        return Console.readLine();
    }

}
