package racingcar.model;

public enum MessageEnum {
    INPUT_CAR_NAME_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

    private String Message;

    MessageEnum(String message) {
        Message = message;
    }

    public String getMessage() {
        return Message;
    }
}
