package racingcar.model;

public enum MessageEnum {
    INPUT_CAR_NAME_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_TRY_NUMBER_MESSAGE("시도할 회수는 몇회인가요?"),
    MIN_SIZE_VALIDATE_MESSAGE("최소 " + NumberEnum.MIN_SIZE.getNumber() + "대의 차는 입력해야 합니다."),
    DUPLICATION_VALIDATE_MESSAGE("중복되는 차량의 이름이 존재합니다."),
    RESULT_MESSAGE("실행 결과"),
    MOVEMENT("-"),
    INVALID_INPUT_MESSAGE("유효하지 않은 정보를 입력했습니다."),
    BLANK_INPUT_MESSAGE("공백은 입력 불가능합니다."),
    MAX_LENGTH_EXCEEDED("입력한 이름 중 길이가 " + NumberEnum.MAX_LENGTH.getNumber() + "가 넘는 이름이 있습니다."),
    UNDER_MIN_TRY_NUMBER("최소 " + NumberEnum.MIN_TRY_NUMBER.getNumber() + "이상의 숫자를 입력하셔야 합니다."),
    WINNER_MESSAGE("최종 우승자 : ");

    private String Message;

    MessageEnum(String message) {
        Message = message;
    }

    public String getMessage() {
        return Message;
    }
}
