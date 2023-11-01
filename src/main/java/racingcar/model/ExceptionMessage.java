package racingcar.model;

public enum ExceptionMessage {
    inputIntegerRoundErrorMessage("시도할 횟수는 1이상이어야 합니다."),
    inputStringRoundErrorMessage("시도할 횟수는 숫자여야 합니다."),
    carNameTooLongErrorMessage("경주할 자동차 이름은 5자 이하만 가능합니다."),
    duplicateCarNameErrorMessage("경주할 자동차 이름은 유일해야 합니다.");
    ;

    private final String message;
    ExceptionMessage(String message) {
        this.message=message;
    }

    private String getMessage(){
        return message;
    }
}
