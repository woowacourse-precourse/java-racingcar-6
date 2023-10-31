package racingcar;

public class Error {
    static Error check = new Error();
    private Error() {
    }

    public void isFiveLengthBelow(int length) {
        if (length > 5) {
            throw new IllegalArgumentException("이름은 5자 이내로 입력해 주세요");
        }
    }

    public void isAllInteger(String number) {
        if (!number.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("숫자만 입력해 주세요");
        }
    }
}
