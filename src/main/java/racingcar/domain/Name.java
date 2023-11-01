package racingcar.domain;


public record Name(String value) {

    private static final String CAR_NAME_LENGTH_ERROR = "[ERROR] 자동차 이름은 1글자 이상 5글자 이하만 가능합니다.";
    private static final int MAX_LENGTH = 5;
    private static final int MIN_LENGTH = 1;

    public Name {

        if (value.length() < MIN_LENGTH || value.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR);
        }
    }
}
