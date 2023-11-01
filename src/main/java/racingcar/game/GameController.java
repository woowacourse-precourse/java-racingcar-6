package racingcar.game;

import static racingcar.utils.constants.RacingCarGameConstants.COMMA_DELIMITER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.utils.randomGenerator.RandomNumberGeneratorImpl;
import racingcar.utils.reader.ConsoleReader;
import racingcar.utils.reader.Reader;
import racingcar.utils.validator.AttemptCountValidator;
import racingcar.utils.validator.CarNameValidator;
import racingcar.utils.validator.Validator;
import racingcar.utils.writer.ConsoleWriter;
import racingcar.utils.writer.Writer;

public class GameController {

    private static final String inputCarNameContext = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String inputAttemptCountContext = "시도할 회수는 몇회인가요?";
    private final RacingCarGame racingCarGame;
    private final Reader reader;
    private final Writer writer;
    private final Validator carNameValidator;

    private final Validator attemptCountValidator;


    public GameController() {
        this.reader = new ConsoleReader();
        this.writer = new ConsoleWriter();
        this.racingCarGame = new RacingCarGame(new RandomNumberGeneratorImpl(), this.writer);
        this.attemptCountValidator = new AttemptCountValidator();
        this.carNameValidator = new CarNameValidator();
    }

    public void start() {
        String carNameContext = inputCarName();
        carNameValidator.validate(carNameContext);
        String attemptCount = inputAttemptCount();
        attemptCountValidator.validate(attemptCount);
        racingCarGame.play(carNameContext, Integer.parseInt(attemptCount));
    }

    private String inputAttemptCount() {
        writer.write(inputAttemptCountContext);
        return reader.read();
    }

    private String inputCarName() {
        writer.write(inputCarNameContext);
        return reader.read();
    }
}
