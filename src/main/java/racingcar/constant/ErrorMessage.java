package racingcar.constant;

public enum ErrorMessage {
    NAME_ERROR("이름을 잘못 입력하셨습니다. 여러 이름을 입력할 때는 쉼표로 구분됩니다."),
    COUNT_ERROR("올바른 횟수를 입력해주세요.");
    public String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
