package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String ROUND_RESULT_NAME_FORMAT = " : %s\n";
    private static final String DASH = "-";
    private static final String WINNER_MESSAGE_FORMAT = "최종 우승자 : %s";
    private static final String WINNERS_DELIMITER = ", ";

    private static final OutputView instance = new OutputView();

    private OutputView() {
    }

    public static OutputView getInstance() {
        return instance;
    }

    public void printStartResultMessage() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
    }

    public void printRoundResult(List<String> carNames, List<Integer> positions) {
        String roundResultMessageFormat = createRoundResultMessageFormat(carNames);
        List<String> positionMarks = positions.stream()
                .map(DASH::repeat)
                .toList();
        System.out.println(String.format(roundResultMessageFormat, positionMarks.toArray()));
    }

    public void printWinners(List<String> winnerNames) {
        if (winnerNames.size() == 1) {
            String winnerMessage = String.format(WINNER_MESSAGE_FORMAT, winnerNames.toArray());
            System.out.println(winnerMessage);
            return;
        }
        String winnerNamesString = String.join(WINNERS_DELIMITER, winnerNames);
        System.out.println(String.format(WINNER_MESSAGE_FORMAT, winnerNamesString));
    }

    private String createRoundResultMessageFormat(List<String> carNames) {
        return carNames.stream()
                .map(name -> name + ROUND_RESULT_NAME_FORMAT)
                .collect(Collectors.joining());
    }
}
