package racingcar.view.output;

import racingcar.dto.GameResult;
import racingcar.view.GameMessage;

import java.util.List;
import java.util.stream.Collectors;

public class OutputViewImpl implements OutputView {
    @Override
    public void printInputCarNamesMessage() {
        printMessage(GameMessage.START);
    }

    @Override
    public void printInputRetryCountMessage() {
        printMessage(GameMessage.ASK_RETRY_COUNT);
    }

    @Override
    public void printTotalGameResults(List<List<GameResult>> totalGameResult) {
        totalGameResult.forEach(gameResults -> {
            printResult(gameResults);
            System.out.println();
        });
    }

    @Override
    public void printWinners(List<String> winners) {
        String output = GameMessage.WINNER.getMessage()
                .formatted(makeWinnerString(winners));
        System.out.println(output);
    }

    private void printResult(List<GameResult> gameResults) {
        gameResults.forEach(result -> printPersonalResult(result));
    }

    private void printPersonalResult(GameResult gameResult) {
        String resultString = GameMessage.PERSONAL_RESULT.getMessage()
                .formatted(gameResult.getName(), gameResult.getPosition());
        System.out.println(resultString);
    }

    private String makeWinnerString(List<String> winnerNames) {
        return winnerNames.stream().collect(Collectors.joining(", "));
    }

    private void printMessage(GameMessage message) {
        System.out.println(message.getMessage());
    }
}
