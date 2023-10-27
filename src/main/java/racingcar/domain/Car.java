package racingcar.domain;

import org.junit.platform.commons.util.StringUtils;

public class Car {
    
    private static final String INVALID_CAR_NAME_MESSAGE = "잘못된 입력입니다.";
    private static final String FORWARD_TRAIL_INDICATOR = "-";
    private static final int MINIMUM_CAR_NAME_LENGTH = 1;
    private static final int MAXIMUM_CAR_NAME_LENGTH = 5;
    
    private final String name;
    private final int forwardCount;

    public Car(String name) {
        this(name, 0);
    }

    private Car(String name, int forwardCount) {
        validate(name);
        this.name = name;
        this.forwardCount = forwardCount;
    }

    public Car increaseForwardCount() {
        return new Car(name, forwardCount + 1);
    }

    public String receiveForwardTrail() {
        return FORWARD_TRAIL_INDICATOR.repeat(forwardCount);
    }

    private void validate(String name) {
        validateInput(name);
        validateLength(name);
    }
    
    private void validateLength(String name) {
        int length = name.length();
        if (length < MINIMUM_CAR_NAME_LENGTH || length > MAXIMUM_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_MESSAGE);
        }
    }
    
    private void validateInput(String name) {
        if (hasBlank(name)) {
            throw new IllegalArgumentException(INVALID_CAR_NAME_MESSAGE);
        }
    }
    
    private boolean hasBlank(String name) {
        return StringUtils.containsWhitespace(name);
    }
}
