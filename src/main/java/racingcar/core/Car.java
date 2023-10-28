package racingcar.core;

import racingcar.util.RandomNumber;

public class Car {
    private static final String BLANK_ERROR_FORMAT = "자동차 이름은 null 이거나 빈 값일 수 없습니다.";
    private static final String LENGTH_ERROR_FORMAT = "자동차 이름은 길이가 %d 이하이어야 합니다.";
    private static final String RESULT_FORMAT = "%s : %s";
    private static final int MAX_NAME_LENGTH = 5;
    private static final int FORWARD_THRESHOLD = 4;
    private final String name;
    private int forwardCount;
    private int trialCount;

    public Car(String name) {
        validateCarName(name);
        this.name = name;
        this.forwardCount = 0;
        this.trialCount = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getForwardCount() {
        return this.forwardCount;
    }

    public int getTrialCount() {
        return this.trialCount;
    }

    public void move() {
        if (RandomNumber.generateSingleDigit() >= FORWARD_THRESHOLD) {
            this.forwardCount++;
        }
        this.trialCount++;
    }

    public String getCurrentStatusString() {
        final String forwardStatus = "-".repeat(this.forwardCount);
        return String.format(RESULT_FORMAT, this.name, forwardStatus);
    }

    private void validateCarName(String name) {
        validateCarNameNotBlank(name);
        validateCarNameLength(name);
    }

    private void validateCarNameNotBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(BLANK_ERROR_FORMAT);
        }
    }

    private void validateCarNameLength(String name) {
        final String errorMessage = String.format(LENGTH_ERROR_FORMAT, MAX_NAME_LENGTH);
        if (name == null || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
