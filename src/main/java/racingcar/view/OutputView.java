package racingcar.view;

import racingcar.domain.CarDistanceMessage;
import racingcar.domain.WinnersMessage;

import java.util.List;

public class OutputView {

    public static final String GET_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String GET_ATTEMPT_MESSAGE = "시도할 횟수는 몇회인가요?";
    public static final String RESULT_MESSAGE = "실행 결과";

    public void printGetCarNamesMessage() {
        System.out.println(GET_CAR_NAMES_MESSAGE);
    }

    public void printGetAttemptMessage() {
        System.out.println(GET_ATTEMPT_MESSAGE);
    }

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printCarDistanceMessages(List<CarDistanceMessage> messages) {
        messages.forEach(System.out::println);
        System.out.println();
    }

    public void printWinnersMessage(WinnersMessage message) {
        System.out.println(message);
    }

}
