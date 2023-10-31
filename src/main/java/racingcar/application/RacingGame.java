package racingcar.application;

import static racingcar.contants.RacingGameConstants.ATTEMPT_COUNT_MESSAGE;
import static racingcar.contants.RacingGameConstants.EXECUTION_RESULT_MESSAGE;
import static racingcar.contants.RacingGameConstants.INPUT_CAR_NAMES_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.ParticipantCars;
import racingcar.util.GameResult;

public class RacingGame {
    public static void start() {
        String inputCarNames = getCarNamesFromUserInput();
        int count = getAttemptCountFromUserInput();

        ParticipantCars participantCars = ParticipantCars.createParticipantCars(inputCarNames);
        runRace(count, participantCars);
    }

    private static String getCarNamesFromUserInput() {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        return Console.readLine();
    }

    private static int getAttemptCountFromUserInput() {
        System.out.println(ATTEMPT_COUNT_MESSAGE);
        return Integer.parseInt(Console.readLine());
    }

    private static void runRace(int count, ParticipantCars participantCars) {
        System.out.println(EXECUTION_RESULT_MESSAGE);
        for (int i = 0; i < count; i++) {
            participantCars.moveCars();
            GameResult.result(participantCars.getParticipantCars());
        }
        GameResult.finalResult(participantCars.getWinners());
    }
}
