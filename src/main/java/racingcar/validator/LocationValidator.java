package racingcar.validator;

public class LocationValidator implements BasicValidator<Integer> {

    @Override
    public void validate(Integer location) {
        isNaturalNumber(location);
    }

    private void isNaturalNumber(Integer location) {
        if (location < 0) {
            throw new IllegalArgumentException("자연수가 아닙니다.");
        }
    }
}
