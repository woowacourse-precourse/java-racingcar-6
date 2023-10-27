package racingcar.view;

import java.util.List;
import racingcar.domain.RacingGameState;

public class OutputView {
    private static final String GAME_RESULT_MESSAGE = "\n실행 결과";

    private static final String CAR_STATE_EXPRESSION = "%s : %s%n";
    private static final String DISTANCE_EXPRESSION_ELEMENT = "-";
    private static final String WINNERS_JOIN_DELIMITER = ", ";
    private static final String WINNER_EXPRESSION = "최종 우승자 : %s%n";

    private String buildCarStateExpression(String carName, int carDistance) {
        String carDistanceExpression = DISTANCE_EXPRESSION_ELEMENT.repeat(carDistance);
        return String.format(CAR_STATE_EXPRESSION, carName, carDistanceExpression);
    }

    private String joinWinnerCarNames(List<String> carNames) {
        return String.join(WINNERS_JOIN_DELIMITER, carNames);
    }

    private String buildWinnerString(RacingGameState racingGameState) {
        return joinWinnerCarNames(racingGameState.getWinnersName());
    }

    public void printGameResultMessage() {
        System.out.println(GAME_RESULT_MESSAGE);
    }

    public void printGameState(RacingGameState racingGameState) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < racingGameState.getCarAmount(); i++) {
            String carName = racingGameState.getCarNameByIndex(i);
            int carDistance = racingGameState.getCarDistanceByIndex(i);

            String carStateExpression = buildCarStateExpression(carName, carDistance);
            sb.append(carStateExpression);
        }
        System.out.println(sb);
    }

    public void printWinners(RacingGameState racingGameState) {
        String winnerInformation = buildWinnerString(racingGameState);
        System.out.printf(WINNER_EXPRESSION, winnerInformation);
    }

}
