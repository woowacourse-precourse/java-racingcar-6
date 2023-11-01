package racingcar.view;

import java.util.Map;
import java.util.StringJoiner;
import racingcar.domain.GameRankings;
import racingcar.domain.GameResult;
import racingcar.domain.GameRound;
import racingcar.domain.car.Name;
import racingcar.domain.car.RacingCars;

public class ConsoleOutputView implements OutputView {

    private static final String EXECUTION_RESULT_MESSAGE = "\n실행 결과\n";
    private static final String EXECUTION_RESULT_SEPARATOR = "\n";
    private static final String END_RESULT_MESSAGE = "최종 우승자 : ";
    private static final String END_RESULT_SEPARATOR = ", ";

    @Override
    public void printResult(GameResult gameResult) {
        printExecutionResult(gameResult);
        printEndResult(gameResult);
    }

    private void printExecutionResult(GameResult gameResult) {
        GameRankings eachRoundResult = gameResult.getEachRoundResult();
        Map<GameRound, RacingCars> gameRankings = eachRoundResult.getGameRankings();

        String stringJoiner = convertObjectToView(gameRankings);
        print(stringJoiner);
    }

    private void printEndResult(GameResult gameResult) {
        String stringBuilder = convertObjectToView(gameResult);
        print(stringBuilder);
    }

    private String convertObjectToView(Map<GameRound, RacingCars> gameRankings) {
        StringJoiner stringJoiner = new StringJoiner(EXECUTION_RESULT_SEPARATOR);
        stringJoiner.add(EXECUTION_RESULT_MESSAGE);

        gameRankings.forEach((gameRound, racingCars) -> {
            stringJoiner.add(racingCars.toString());
        });
        return stringJoiner.toString();
    }

    private String convertObjectToView(GameResult gameResult) {
        StringBuilder stringBuilder = new StringBuilder();
        StringJoiner stringJoiner = new StringJoiner(END_RESULT_SEPARATOR);

        stringBuilder.append(END_RESULT_MESSAGE);
        for (Name winnerNames : gameResult.getWinners().winners()) {
            stringJoiner.add(winnerNames.name());
        }
        stringBuilder.append(stringJoiner);
        return stringBuilder.toString();
    }

    private void print(String message) {
        System.out.println(message);
    }
}
