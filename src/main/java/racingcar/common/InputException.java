package racingcar.common;

public final class InputException {

    public static void tryCountValidate(String tryCount) {
        if (!Character.isDigit(tryCount.charAt(0))) throw new IllegalArgumentException("시도할 횟수는 자연수이어야 합니다.");
        int count = Integer.parseInt(tryCount);
        if (count <= 0) throw new IllegalArgumentException("시도할 횟수는 1 이상이어야 합니다.");
    }

    public static void carNameValidate(String[] input) {
        for (int i = 0; i < input.length; i++) {
            if (input[i].length() > 5) {
                throw new IllegalArgumentException("자동차의 이름은 5글자 이내여야 합니다.");
            }
        }
    }
}
