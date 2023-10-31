package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.function.Supplier;

public class InputView {

    private static final String ASK_CAR_NAMES = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private static final String ASK_ROUND_NUMBER = "시도할 회수는 몇회인가요?";
    private static final String COMMA = ",";
    private static final String ERROR_INPUT_MUST_NUMBER = "입력값은 숫자여야 합니다.";
    private final Supplier<String> reader;

    public InputView() {
        this(Console::readLine);
    }

    public InputView(Supplier<String> reader) {
        this.reader = reader;
    }

    public List<String> askCarNames() {
        println(ASK_CAR_NAMES);
        String carNamesInput = reader.get();
        String[] carNames = carNamesInput.split(COMMA);
        return List.of(carNames);
    }

    public int askRoundNumber() {
        println(ASK_ROUND_NUMBER);
        String roundNumberInput = reader.get();
        return toInteger(roundNumberInput);
    }

    private int toInteger(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INPUT_MUST_NUMBER);
        }
    }

    private void println(String message) {
        System.out.println(message);
    }
}
