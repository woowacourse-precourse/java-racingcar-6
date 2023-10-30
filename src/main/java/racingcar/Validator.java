package racingcar;


public class Validator {
    public void verifyLength(int start, int end, String s) {
        if (s.length() < start || s.length() > end) {
            throw new IllegalArgumentException("제한된 범위에 포함되지 않습니다.");
        }
    }

    public void verifyNullAndBlank(String s) {
        if (s == null || s.isBlank()) {
            throw new IllegalArgumentException("공백혹은 빈 문자열은 허용하지 않습니다.");
        }
    }

    public void verifyDigitPerUnit(String numberOfAttempts) {
        numberOfAttempts.chars().filter(number -> !Character.isDigit(number))
                .findAny()
                .ifPresent((notNUmber) -> {
                    throw new IllegalArgumentException("숫자가 아닌 값이 들어가있습니다.");
                });
    }

    public void verifyInRangeClosed(int start, int end, int value) {
        if (value < start || value > end) {
            throw new IllegalArgumentException("범위안에 속하지 않습니다.");
        }
    }
}
