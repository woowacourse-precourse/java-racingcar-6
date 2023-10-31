package racingcar;


public class Validator {
    public void verifyNullAndBlank(String s) {
        if (s == null || s.isBlank()) {
            throw new IllegalArgumentException("공백혹은 빈 문자열은 허용하지 않습니다.");
        }

        s.chars().filter(Character::isWhitespace)
                .findAny().ifPresent((character) -> {
                    throw new IllegalArgumentException("공백이 포함될 수 없습니다.");
                });
    }

    public void verifyDigitPerUnit(String numberOfAttempts) {
        if (numberOfAttempts==null || numberOfAttempts.length() < 1) {
            throw new IllegalArgumentException("숫자가 아닌 값이 들어가있습니다.");
        }

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
