package racingcar.domain.car.vo;

public record CarName(
        String name
) {
    private static final int MAX_NAME_LENGTH = 5;

    public CarName {
        validate(name);
    }

    private void validate(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 " + MAX_NAME_LENGTH + "글자를 초과할 수 없습니다.");
        }
    }
}
