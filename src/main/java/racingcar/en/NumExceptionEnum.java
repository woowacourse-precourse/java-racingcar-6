package racingcar.en;

public enum NumExceptionEnum {

    NOT_INTEGER("정수가 아닌 값을 입력"),
    WRONG_LENGTH("잘못된 길이 입력");

    public String msg;

    NumExceptionEnum(String msg) {
        this.msg = msg;
    }
}
