package racingcar.view;

public class ConsoleOutput {
    public static final String CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String TRY_MESSAGE = "시도할 회수는 몇회인가요?";
    public static final String ROUND_RESULT_MESSAGE = "실행 결과";

    public static void displayMessage(String message) {
        System.out.println(message);
    }
}
