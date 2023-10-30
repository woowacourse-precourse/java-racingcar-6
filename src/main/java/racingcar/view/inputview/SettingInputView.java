package racingcar.view.inputview;

import java.util.Map;
import java.util.function.Supplier;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class SettingInputView implements InputView {
    public static final char DELIMITER = ',';
    private final Map<String, Supplier<String>> methodMap = Map.ofEntries(
            Map.entry("carNames", this::readCarNames),
            Map.entry("gameCount", this::readGameCount)
    );

    private final InputValidator inputValidator;

    public SettingInputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    @Override
    public void read(Map<String, String> parameter) {
        parameter.keySet()
                .forEach(name -> runMethodByName(parameter, name));
    }

    private void runMethodByName(Map<String, String> parameter, String name) {
        if (!methodMap.containsKey(name)) {
            throw new IllegalArgumentException();
        }
        parameter.computeIfAbsent(name, e -> methodMap.get(e).get());
    }

    private String readCarNames() {
        String input = readLine().trim();
        inputValidator.isSameNameSizeToDelimiter(input);
        return input;
    }

    private String readGameCount() {
        String input = readLine().trim();
        inputValidator.isOnlyNaturalNumber(input);
        inputValidator.isEmpty(input);
        return input;
    }
}
