package racingcar.view.inputview;

import java.util.Map;
import java.util.function.Supplier;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class SettingInputView implements InputView {
    static final char DELIMITER = ',';
    private final Map<String, Supplier<Object>> methodMap = Map.ofEntries(
            Map.entry("carNames", this::readCarNames),
            Map.entry("gameCount", this::readGameCount)
    );

    private final InputValidator inputValidator;

    public SettingInputView(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    @Override
    public void read(Map<String, Object> readEntities) {
        readEntities.keySet()
                .forEach(name -> runMethodByName(readEntities, name));
    }

    private void runMethodByName(Map<String, Object> readEntities, String name) {
        if (!methodMap.containsKey(name)) {
            throw new IllegalArgumentException();
        }
        readEntities.computeIfAbsent(name, e -> methodMap.get(e).get());
    }

    private String readCarNames() {
        String input = readLine().trim();
        inputValidator.isSameNameSizeToDelimiter(input);
        return input;
    }

    private String readGameCount() {
        String input = readLine().trim();
        if (input != null) {
            inputValidator.isOnlyNaturalNumber(input);
            inputValidator.isEmpty(input);
        }
        return input;
    }
}
