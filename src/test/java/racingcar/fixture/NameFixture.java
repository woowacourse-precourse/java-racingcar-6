package racingcar.fixture;

import racingcar.domain.Car;

public enum NameFixture {

    // Valid
    VALID_ENGLISH("happy"),
    VALID_KOREAN("변해빈"),

    // Invalid
    INVALID_TOO_LONG("우테코재밌다"),
    INVALID_EMPTY(""),
    INVALID_CONTAIN_WHITE_SPACE("해   빈"),
    INVALID_CONTAIN_TAB("해\t빈");

    private final String name;

    NameFixture(String name) {
        this.name = name;
    }

    public Car toEntity() {
        return Car.create(name);
    }

    public String getName() {
        return name;
    }
}
