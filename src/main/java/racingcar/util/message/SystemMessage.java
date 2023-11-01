package racingcar.util.message;

import java.util.function.Consumer;
import racingcar.constant.InputDelimiter;

public enum SystemMessage {

    INPUT_CAR_NAME_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(" +
            InputDelimiter.PARTICIPANT_INPUT_DELIMITER.getValue() +
            ") 기준으로 구분)", System.out::println),
    INPUT_TRIAL_MESSAGE("시도할 회수는 몇회인가요?", System.out::println),
    RESULT_HEADER_MESSAGE("\n실행 결과", System.out::println);

    private final String message;
    private final Consumer<String> print;

    SystemMessage(String message, Consumer<String> print) {
        this.message = message;
        this.print = print;
    }

    public void printMessage() {
        print.accept(message);
    }

}
