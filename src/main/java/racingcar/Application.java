package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        String[] participants = InputValidation.askCarNames();
        int totalMoves = InputValidation.askTotalMoveCounts();

        RacingGame game = new RacingGame(totalMoves);

        game.addParticipants(participants);
        game.proceed();
        System.out.println(game.getResult());
    }
}
