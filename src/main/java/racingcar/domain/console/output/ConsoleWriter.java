package racingcar.domain.console.output;

public class ConsoleWriter {
    private static final String INPUT_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_ATTEMPT_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    private ConsoleWriter() {
    }

    public static ConsoleWriter newInstance() {
        return new ConsoleWriter();
    }

    public void inputNamesMessagePrint() {
        System.out.println(INPUT_NAMES_MESSAGE);
    }

    public void inputCountMessagePrint() {
        System.out.println(INPUT_ATTEMPT_COUNT_MESSAGE);
    }

    public void println(final String message) {
        System.out.println(message);
    }
}
