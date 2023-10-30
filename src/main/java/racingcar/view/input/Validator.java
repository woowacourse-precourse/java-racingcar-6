package racingcar.view.input;

public interface Validator {

    String NAME_LENGTH_LIMIT_ERROR = "이름은 5글자 이하로 작성해주세요.";
    int NAME_LENGTH_LIMIT = 5;

    void validateCarName(String carName);
}
