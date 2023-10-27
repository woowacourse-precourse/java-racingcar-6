package racingcar.view;

import racingcar.domain.RacingGameState;

public class OutputView {
    private static final String GAME_RESULT_MESSAGE = "\n실행 결과";

    private static final String CAR_STATE_EXPRESSION = "%s : %s%n";
    private static final String DISTANCE_EXPRESSION_ELEMENT = "-";

    private String buildCarDistanceExpression(int carDistance) {
        return DISTANCE_EXPRESSION_ELEMENT.repeat(carDistance);
    }

    private String buildCarStateExpression(String carName, int carDistance) {
        String carDistanceExpression = buildCarDistanceExpression(carDistance);
        return String.format(CAR_STATE_EXPRESSION, carName, carDistanceExpression);
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


}
