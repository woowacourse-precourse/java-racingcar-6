package racingcar.domain;

public record Name(
        String value
) {

    public Name {
        validate(value);
    }

    private void validate(String value) {
        if (value.length() > NameConstraints.MAX_NAME_LENGTH.getValue() || value.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상, 5자 이하만 가능합니다.");
        }
    }
}
