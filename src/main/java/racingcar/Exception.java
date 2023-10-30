package racingcar;

public class Exception {

    public void checkCountCarNames() {
        throw new IllegalArgumentException("이름이 하나만 입력되었습니다.");
    }

    public void checkSpace() {
        throw new IllegalArgumentException("입력에 공백이 존재합니다.");
    }

    public void checkLengthCarName() {
        throw new IllegalArgumentException("이름이 5자를 초과하였습니다.");
    }

    public void checkDuplicate() {
        throw new IllegalArgumentException("중복된 이름이 존재합니다.");
    }

    public void checkNothing() {
        throw new IllegalArgumentException("입력이 존재하지 않습니다.");
    }

    public void checkIsDigit() {
        throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다.");
    }

}