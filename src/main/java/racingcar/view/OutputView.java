package racingcar.view;

import racingcar.enums.Constants;
import racingcar.enums.Messages;
import racingcar.model.Distance;
import racingcar.model.Name;
import racingcar.model.RacingResult;

import java.util.List;

public class OutputView {
    static StringBuilder sb;
    public static void printInputRacingCar() {
        System.out.println(Messages.INPUT_RACING_CAR_MESSAGE.getMessage());
    }

    public static void printInputTryNumber() {
        System.out.println(Messages.INPUT_TRY_NUMBER_MESSAGE.getMessage());
    }

    public static void printRacingResult() {
        System.out.println(Messages.RACING_RESULT.getMessage());
    }

    public static void printOneRoundResult(RacingResult racingResult, List<Name> carNames) {
        sb = new StringBuilder();
        for (Name name : carNames) {
            sb.append(name.getName()).append(Constants.SEPARATOR.getMessage());
            printDistance(racingResult.getRacingResult().get(name));
            changeLine();
        }
        System.out.println(sb);
    }

    public static void printFinalWinner(List<Name> winners) {
        sb = new StringBuilder();
        sb.append(Messages.FINAL_WINNER.getMessage()).
                append(Constants.SEPARATOR.getMessage());

        for (Name name : winners) {
            sb.append(name.getName()).append(Constants.COMMA.getMessage());
        }

        System.out.println(sb.substring(0, sb.length() - 1));
    }

    private static void printDistance(Distance distance) {
        for (int d = 0; d < distance.getDistance(); d++) {
            sb.append(Constants.MOVE.getMessage());
        }
    }

    private static void changeLine() {
        sb.append(Constants.LINE_CHANGER.getMessage());
    }
}
