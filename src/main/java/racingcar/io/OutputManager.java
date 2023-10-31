package racingcar.io;

import racingcar.config.GameMessages;
import racingcar.dto.CarStateDto;
import racingcar.dto.GameResultDto;
import racingcar.dto.RoundResultDto;

import java.util.List;

public class OutputManager {
    private static final String JOIN_DELIMITER = ", ";

    public void printCarNameInputMessage() {
        printMessage(GameMessages.INPUT_CAR_NAME);
    }
    public void printTryCountInputMessage() {
        printMessage(GameMessages.INPUT_TRY_COUNT);
    }
    public void printExecutionResultMessage() {
        printMessage(GameMessages.EXECUTION_RESULT);
    }

    public void printRoundResult(RoundResultDto roundResultDto) {
        List<CarStateDto> carStates = roundResultDto.getCarStates();
        for (CarStateDto carState : carStates) {
            printMessage(carState.getCarStatus());
        }
    }

    public void printFinalWinner(GameResultDto gameResult) {
        String winnerNames = String.join(JOIN_DELIMITER, gameResult.getWinnerNames());
        printMessage(GameMessages.FINAL_WINNER + winnerNames);
    }

    public void printLine() {
        printMessage("");
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

}
