package racingcar;

public class Exceptions {

    public void isInvalidCarNameLength(String input) {
        if (input.length() <= 5) {
            return;
        }
        throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
    }
}
