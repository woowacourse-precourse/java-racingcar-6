package racingcar.view;

public class OutputView {
    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String TRY_MESSAGE = "시도할 횟수는 몇 회인가요?";

    public static void printString(String string) {
        System.out.println(string);
    }

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printTryMessage() {
        System.out.println(TRY_MESSAGE);
    }
}