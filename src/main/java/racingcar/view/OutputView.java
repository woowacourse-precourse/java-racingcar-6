package racingcar.view;

public class OutputView {

    private final static String INPUT_CAR_NAME_MSG = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String INPUT_TRY_MSG = "시도할 회수는 몇회인가요?";
    private final static String RESULT_MSG = "실행 결과";

    public static void printInputCarName() {
        System.out.println(INPUT_CAR_NAME_MSG);
    }

    public static void printInputTry() {
        System.out.println(INPUT_TRY_MSG);
    }

    public void printResultMsg() {
        System.out.println();
        System.out.println(RESULT_MSG);
    }

    public void printExceptionMsg(String errorMsg) {
        System.out.println(errorMsg);
    }

    public void printResult(String curResult) {
        System.out.println(curResult);
    }
}
