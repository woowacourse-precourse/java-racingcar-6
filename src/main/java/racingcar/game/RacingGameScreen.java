package racingcar.game;

import racingcar.common.io.reader.Reader;
import racingcar.common.io.writer.Writer;

public class RacingGameScreen {

    private static final String INPUT_RACER_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    private final Reader reader;
    private final Writer writer;

    public RacingGameScreen(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public String inputRacer(){
        writer.writeLine(INPUT_RACER_MESSAGE);
        return reader.readLine();
    }
}
