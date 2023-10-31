package racingcar.model.car;

public class CarName {

    public static final String NAME_LENGTH_LIMIT_EXCEEDED = "자동차 이름은 5자 이하만 가능합니다.";
    public static final String NAME_DUPLICATED = "중복된 이름을 입력할 수 없습니다.";

    private static final int NAME_LENGTH_LIMIT = 5;

    private final String name;

    private CarName(final String name) {
        validateLength(name);
        this.name = name;
    }

    public static CarName from(final String name) {
        return new CarName(name);
    }

    private void validateLength(final String name) {
        if (name.length() > NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(NAME_LENGTH_LIMIT_EXCEEDED);
        }
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof CarName carName
                && name.equals(carName.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }
}
