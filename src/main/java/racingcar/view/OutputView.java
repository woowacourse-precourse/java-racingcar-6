package racingcar.view;

import java.util.List;

public class OutputView {
    private final static String REQUEST_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final static String REQUEST_NUMBER_OF_TRY_MESSAGE = "시도할 회수는 몇회인가요?";
    private final static String RACE_RESULT_MESSAGE = "실행 결과";
    private final static String MOVEMENT = "-";

    public void requestCarNamesMessage() {
        System.out.println(REQUEST_CAR_NAMES_MESSAGE);
    }

    public void requestNumberOfTryMessage() {
        System.out.println(REQUEST_NUMBER_OF_TRY_MESSAGE);
    }

    public void raceResultMessage() {
        System.out.println(RACE_RESULT_MESSAGE);
    }
}
