package racingcar.domain;

record Name(
        String value
) {

    public Name {
        validate(value);
    }

    private void validate(String value) {
        if (value.length() > NameConstraints.MAX_NAME_LENGTH.getValue()) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

}
