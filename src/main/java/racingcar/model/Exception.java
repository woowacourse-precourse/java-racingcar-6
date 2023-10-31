package racingcar.model;

public class Exception {
    public static void checkNumber(String attemptCount) {
        try {
            int number = Integer.parseInt(attemptCount);
            if (!isPositiveNum(number)) {
                throw new IllegalArgumentException("양의 정수 여야합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자이여야 합니다.");
        }
    }

    public static boolean isPositiveNum(int attemptCount) {
        if (attemptCount > 0) {
            return true;
        }
        return false;
    }

    public static void isSpace(String[] carNames) {
        for (String name : carNames) {
            String word = name.trim();
            if (word.contains(" ")) {
                throw new IllegalArgumentException("이름에 공백이 포함되어 있습니다.");
            }
        }
    }

    public static void isFrontSpace(String carNames) {
        if (carNames.contains(", ")) {
            throw new IllegalArgumentException("이름에 공백이 포함되어 있습니다");
        }
    }
    
}
