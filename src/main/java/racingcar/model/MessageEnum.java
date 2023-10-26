package racingcar.model;

public enum MessageEnum {
    INPUT_CAR_NAME_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    MAX_LENGTH_EXCEEDED("입력한 이름 중 길이가 " + NumberEnum.MAX_LENGTH.getNumber() + "가 넘는 이름이 있습니다.");

    private String Message;

    MessageEnum(String message) {
        Message = message;
    }

    public String getMessage() {
        return Message;
    }
}
