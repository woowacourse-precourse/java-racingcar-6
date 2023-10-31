package racingcar.view;

public class ConsoleOutput {
    public static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String TRY_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String ROUND_RESULT_MESSAGE = "실행 결과";

    public static void displayGetCarNameMessage() {
        System.out.println(CAR_NAME_MESSAGE);
    }

    public static void displayTryMessage() {
        System.out.println(TRY_MESSAGE);
    }

    public static void displayRaceResultMessage() {
        System.out.println(ROUND_RESULT_MESSAGE);
    }

    public static void printNewLine() {
        System.out.println();
    }
}
