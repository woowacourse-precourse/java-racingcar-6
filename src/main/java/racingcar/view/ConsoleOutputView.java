package racingcar.view;

public class ConsoleOutputView implements OutputView {

    private static final String REQUEST_CAR_NAMES = "경주할 자동차 이름을 입력하세요.";
    private static final String SEPARATED_BY = "(이름은 %s(%s) 기준으로 구분)";
    private static final String REQUEST_TRY_COUNT = "시도할 회수는 몇회인가요?";

    @Override
    public void requestCarNames(String delimiterDescription, String delimiter) {
        String separateMessage = createSeparateMessage(delimiterDescription, delimiter);
        System.out.println(REQUEST_CAR_NAMES + separateMessage);
    }

    private String createSeparateMessage(String delimiterDescription, String delimiter) {
        return String.format(SEPARATED_BY, delimiterDescription, delimiter);
    }

    @Override
    public void requestTryCount() {
        System.out.println(REQUEST_TRY_COUNT);
    }
}
