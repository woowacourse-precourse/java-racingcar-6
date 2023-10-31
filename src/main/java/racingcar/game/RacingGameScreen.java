package racingcar.game;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.common.io.reader.Reader;
import racingcar.common.io.writer.Writer;
import racingcar.game.vo.TurnResult;

public class RacingGameScreen {

    private static final String INPUT_RACER = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_NUMBER_OF_TURNS = "시도할 횟수는 몇 회인가요?";
    private static final String START_SHOW_GAME_RESULT = "실행 결과";
    private static final String FINAL_WINNER = "최종 우승자 : %s";

    private static final char DISTANCE_CHARACTER = '-';

    private final Reader reader;
    private final Writer writer;

    public RacingGameScreen(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public String inputRacer() {
        writer.writeLine(INPUT_RACER);
        return reader.readLine();
    }

    public String inputNumberOfTurns() {
        writer.writeLine(INPUT_NUMBER_OF_TURNS);
        return reader.readLine();
    }

    public void startShowGameResult() {
        writer.writeLine("\n" + START_SHOW_GAME_RESULT);
    }

    public void showTurnResult(TurnResult turnResult) {
        String resultMessage = turnResult.result().stream()
                .map(racerPosition -> String.format("%s : %s", racerPosition.name(),
                        repeatChar(racerPosition.position())))
                .collect(Collectors.joining("\n"));

        writer.writeLine(resultMessage + "\n");
    }

    private String repeatChar(int count) {
        char[] chars = new char[count];
        Arrays.fill(chars, DISTANCE_CHARACTER);

        return String.valueOf(chars);
    }

    public void showFinalWinner(List<String> winnerNames) {
        String winnerName = winnerNames.stream()
                .collect(Collectors.joining(","));

        writer.writeLine(String.format(FINAL_WINNER, winnerName));
    }
}
