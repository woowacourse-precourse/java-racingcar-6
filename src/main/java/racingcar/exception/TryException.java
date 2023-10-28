package racingcar.exception;

public class TryException {

    public void format(String tryCount) {
        checkWord(tryCount);
        zeroOrMinus(tryCount);
    }

    public void checkWord(String tryCount) {
        char[] chars = tryCount.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] < 48 || chars[i] > 57) {
                throw new IllegalArgumentException("시도할 횟수는 숫자를 입력하여야 합니다.");
            }
        }
    }

    public void zeroOrMinus (String tryCount){
        if (Integer.parseInt(tryCount) <= 0) {
            throw new IllegalArgumentException("시도할 횟수는 양수이어야 합니다.");
        }
    }

}
