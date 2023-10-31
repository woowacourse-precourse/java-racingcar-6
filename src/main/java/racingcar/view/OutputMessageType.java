package racingcar.view;

import racingcar.common.MessageType;

public enum OutputMessageType implements MessageType {
    RESULT_MESSAGE("실행 결과"),
    FINAL_RESULT_MESSAGE("최종 우승자"),
    PROGRESS_EMOJI("-"),
    SEPARATOR(" : "),
    COMMAS(", ")
    ;


    private final String message;

    OutputMessageType(final String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
