package racingcar.view;

public class outputView {

    private static final String REQUEST_CAR_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String REQUEST_TRY_NUMBER = "시도할 회수는 몇회인가요?";

    private static final String GAME_RESULT = "실행 결과";

    public void requestCarName() {
        System.out.print(REQUEST_CAR_NAME);
    }

    public void requestTryNumber() {
        System.out.print(REQUEST_TRY_NUMBER);
    }

    public void gameResult() {
        System.out.print(GAME_RESULT);
    }
}
