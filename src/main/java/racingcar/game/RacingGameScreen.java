package racingcar.game;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.common.config.RacingCarRule;
import racingcar.game.vo.TurnResult;
import racingcar.io.reader.Reader;
import racingcar.io.writer.Writer;

public class RacingGameScreen {

    private static final String INPUT_RACER = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TOTAL_TURN = "시도할 횟수는 몇 회인가요?";
    private static final String START_SHOW_GAME_RESULT = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자 : %s";

    private static final String TURN_RESULT_FORMAT = "%s : %s";
    private static final char DISTANCE_CHARACTER = '-';

    private static final String LINE_SEPARATOR = System.lineSeparator();

    private final Reader reader;
    private final Writer writer;

    public RacingGameScreen(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public String inputRacer() {
        writer.writeLine(INPUT_RACER);
        return reader.readLine().trim();
    }

    public String inputTotalTurn() {
        writer.writeLine(INPUT_TOTAL_TURN);
        return reader.readLine().trim();
    }

    public void startShowGameResult() {
        writer.writeLine(LINE_SEPARATOR + START_SHOW_GAME_RESULT);
    }

    public void showTurnResult(TurnResult turnResult) {
        String resultMessage = turnResult.result().stream()
                .map(racerPosition -> String.format(TURN_RESULT_FORMAT, racerPosition.name(),
                        repeatChar(racerPosition.position())))
                .collect(Collectors.joining(LINE_SEPARATOR));

        writer.writeLine(resultMessage + LINE_SEPARATOR);
    }

    private String repeatChar(int count) {
        char[] chars = new char[count];
        Arrays.fill(chars, DISTANCE_CHARACTER);

        return String.valueOf(chars);
    }

    public void showFinalWinner(List<String> winnerNames) {
        String winnerName = String.join(RacingCarRule.INPUT_DELIMITER, winnerNames);

        writer.writeLine(String.format(FINAL_WINNER, winnerName));
    }
}
