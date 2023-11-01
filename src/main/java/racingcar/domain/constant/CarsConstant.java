package racingcar.domain.constant;

import racingcar.util.EnumUtil;

public enum CarsConstant implements EnumUtil<String, String> {
    SPLIT_DELIMITER(",");

    private final String value;

    CarsConstant(final String value) {
        this.value = value;
    }

    @Override
    public String getKey() {
        return this.name();
    }

    @Override
    public String getValue() {
        return value;
    }
}
