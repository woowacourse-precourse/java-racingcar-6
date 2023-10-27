package racingcar.io;

import racingcar.constant.ProgressMessage;

public class OutputView {

    public void printRacingCarNamesRequest() {
        System.out.println(ProgressMessage.RACING_CAR_NAMES_REQUEST.toValue());
    }

    public void printTryCountRequest() {
        System.out.println(ProgressMessage.TRY_COUNT_REQUEST.toValue());
    }

    public void printResult() {
        System.out.println(ProgressMessage.RESULT.toValue());
    }
}
