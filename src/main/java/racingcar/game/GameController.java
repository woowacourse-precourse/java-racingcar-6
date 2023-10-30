package racingcar.game;

import racingcar.utils.reader.Reader;
import racingcar.utils.writer.Writer;

public class GameController {


    public static final String inputCarNameContext = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final RacingCarGame racingCarGame;
    private final Reader reader;
    private final Writer writer;

    public GameController(RacingCarGame racingCarGame, Reader reader, Writer writer) {
        this.racingCarGame = racingCarGame;
        this.reader = reader;
        this.writer = writer;
    }

    public void start() {
        //String carNames = inputCarName();

    }


}
