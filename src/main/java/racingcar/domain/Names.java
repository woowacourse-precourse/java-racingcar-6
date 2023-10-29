package racingcar.domain;

import static racingcar.message.MessageConstants.FIVE;

public record Names(String value) {

    public Names {
        String name = nameTrim(value);
        validationNameLength(name);
    }

    private void validationNameLength(String name) {
        if (name.length() > FIVE || name.isEmpty()) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
        }
    }

    private String nameTrim(String value) {
        return value.trim();
    }

}
