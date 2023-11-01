package racingcar.game;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.common.config.RacingCarRule;
import racingcar.game.vo.RacerPosition;
import racingcar.game.vo.RacingCarNamesInput;
import racingcar.game.vo.TotalTurnInput;
import racingcar.io.reader.Reader;
import racingcar.io.writer.Writer;

public class RacingGameScreen {

    private static final String INPUT_RACING_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TOTAL_TURN = "시도할 횟수는 몇 회인가요?";
    private static final String START_SHOW_GAME_RESULT = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자 : %s";

    private static final String TURN_RESULT_FORMAT = "%s : %s";
    private static final String DISTANCE_MARKER = "-";

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR]: ";

    private static final String LINE_SEPARATOR = System.lineSeparator();

    private final Reader reader;
    private final Writer writer;

    public RacingGameScreen(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public RacingCarNamesInput inputRacingCar() {
        writer.writeLine(INPUT_RACING_CAR_NAMES);
        return new RacingCarNamesInput(reader.readLine().trim());
    }

    public TotalTurnInput inputTotalTurn() {
        writer.writeLine(INPUT_TOTAL_TURN);
        return new TotalTurnInput(reader.readLine().trim());
    }

    public void startShowGameResult() {
        writer.writeLine(LINE_SEPARATOR + START_SHOW_GAME_RESULT);
    }

    public void showTurnResult(List<RacerPosition> turnResult) {
        String resultMessage = turnResult.stream()
                .map(racerPosition -> String.format(TURN_RESULT_FORMAT, racerPosition.name(),
                        DISTANCE_MARKER.repeat(racerPosition.position())))
                .collect(Collectors.joining(LINE_SEPARATOR));

        writer.writeLine(resultMessage + LINE_SEPARATOR);
    }

    public void showFinalWinner(List<String> winnerNames) {
        String winnerName = String.join(RacingCarRule.DELIMITER, winnerNames);

        writer.writeLine(String.format(FINAL_WINNER, winnerName));
    }

    public void showError(String message) {
        writer.writeLine(ERROR_MESSAGE_PREFIX + message);
    }

    public void close() {
        reader.close();
    }
}
