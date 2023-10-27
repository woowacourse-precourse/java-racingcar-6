package racingcar.Util;

public class ErrorCollection {

    public void throwError() {
        throw  new IllegalArgumentException("올바르지 않은 입력입니다.");
    }

    public void IllegalCarNames() {
        throw new IllegalArgumentException("올바르지 않은 입력입니다. 이름 사이를 공백 없이 쉼표(,)를 이용해 구분해 주세요.\n올바른 예) pobi,woni,jun\n");
    }

    public void IllegalAttempts() {
        throw new IllegalArgumentException("올바르지 않은 입력이다. 숫자만 입력해 주세요.");
    }
}
