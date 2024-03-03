package racingcar.view;

public class OutputView {
    private static final String GREETING_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String WIN_MESSAGE = "최종 우승자 :";
    private static final String ERROR_MESSAGE = "[ERROR]: ";

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE + message);
    }
}
