package racingcar.view;

public class OutputView {
    private static final String NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_INPUT_MESSAGE = "시도할 횟수는 몇회인가요?";
    public static void printNameInputMessage() {
        printlnMessage(NAME_INPUT_MESSAGE);
    }

    public static void printRoundInputMessage() {
        printlnMessage(ROUND_INPUT_MESSAGE);
    }

    private static void printlnMessage(String message) {
        System.out.print(message);
    }
}
