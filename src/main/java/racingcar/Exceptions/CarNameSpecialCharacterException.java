package racingcar.Exceptions;

public class CarNameSpecialCharacterException extends IllegalArgumentException {
    public CarNameSpecialCharacterException() {
        super("자동차 이름을 구분하기 위한 쉼표(,)만 특수문자로 사용할 수 있습니다.");
    }
}
