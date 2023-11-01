package racingcar.config;

import java.util.List;
import racingcar.printer.GamePrinter;
import racingcar.scanner.GameScanner;
import racingcar.scanner.NumberOfTimesScanner;
import racingcar.scanner.RacingCarNameScanner;
import racingcar.validator.RacingCarNameValidator;
import racingcar.validator.NumberOfTimesValidator;
import racingcar.validator.Validator;

public class Config {

    private final Validator<List<String>> nameValidator;
    private final Validator<String> numberValidator;

    private final GamePrinter printer;
    private final GameScanner<List<String>> nameScanner;
    private final GameScanner<Integer> numberScanner;

    public Config() {
        this.nameValidator = new RacingCarNameValidator();
        this.numberValidator = new NumberOfTimesValidator();

        this.printer = new GamePrinter();
        this.nameScanner = new RacingCarNameScanner(nameValidator);
        this.numberScanner = new NumberOfTimesScanner(numberValidator);
    }

    public GamePrinter getPrinter() {
        return printer;
    }

    public GameScanner<List<String>> getNameScanner() {
        return nameScanner;
    }

    public GameScanner<Integer> getNumberScanner() {
        return numberScanner;
    }
}
