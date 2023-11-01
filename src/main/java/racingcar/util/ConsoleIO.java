package racingcar.util;

import static racingcar.constant.Constant.COLON;
import static racingcar.constant.Constant.HYPHEN;
import static racingcar.constant.Constant.NEW_LINE;
import static racingcar.constant.GameMessage.FINAL_WINNER_MESSAGE;
import static racingcar.constant.GameMessage.PLAY_RESULT_MESSAGE;
import static racingcar.constant.GameMessage.REQUEST_INPUT_CAR_NAME_MESSAGE;
import static racingcar.constant.GameMessage.REQUEST_INPUT_GAME_SET_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.dto.FinalResultDto;
import racingcar.dto.SetResultDto;

public class ConsoleIO {
    public static String readCarName() {
        System.out.println(REQUEST_INPUT_CAR_NAME_MESSAGE);

        return Console.readLine();
    }

    public static String readGameSet() {
        System.out.println(REQUEST_INPUT_GAME_SET_MESSAGE);

        return Console.readLine();
    }

    public static void printPlayResultMessage() {
        printNewLine();
        System.out.println(PLAY_RESULT_MESSAGE);
    }

    public static void printSetResult(SetResultDto setResultDto) {
        StringBuilder setResult = new StringBuilder();

        for (String carName : setResultDto.getCarNameSet()) {
            setResult.append(carName).append(COLON).append(HYPHEN.repeat(setResultDto.getMove(carName)))
                    .append(NEW_LINE);
        }

        System.out.println(setResult);
    }

    public static void printFinalResult(FinalResultDto finalResultDto) {
        StringBuilder finalResult = new StringBuilder(FINAL_WINNER_MESSAGE);

        List<String> winner = finalResultDto.winners();

        finalResult.append(winner.get(0));

        if (winner.size() > 1) {
            for (int i = 1; i < winner.size(); i++) {
                finalResult.append(", ").append(winner.get(i));
            }
        }

        System.out.println(finalResult);
    }

    private static void printNewLine() {
        System.out.println();
    }
}
