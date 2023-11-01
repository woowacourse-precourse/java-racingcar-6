package tdd.config;

import static tdd.config.RacingConfig.INPUT_CAR_NAME_LENGTH_MAX;
import static tdd.config.RacingConfig.INPUT_CAR_NAME_LENGTH_MIN;
import static tdd.config.RacingConfig.SPLIT_CAR_NAME_LENGTH_MAX;
import static tdd.config.RacingConfig.SPLIT_CAR_NAME_LENGTH_MIN;

public enum InputPattern {
    SPLIT_CAR_NAME_REGEX("^[a-z0-9]*$"),
    SPLIT_CAR_NAME_LENGTH_REGEX(String.format("^.{%d,%d}$",
            SPLIT_CAR_NAME_LENGTH_MIN.getValue(), SPLIT_CAR_NAME_LENGTH_MAX.getValue())),

    INPUT_CAR_NAME_LENGTH_REGEX(String.format("^.{%d,%d}$",
            INPUT_CAR_NAME_LENGTH_MIN.getValue(), INPUT_CAR_NAME_LENGTH_MAX.getValue())),

    INPUT_CAR_NAME_COMMA_REGEX("^(?!,)(.*[^,])?$"),

    ATTEMPT_COUNT_REGEX("^(?:[1-9][0-9]{0,2}|1000)$");

    private final String regex;

    InputPattern(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
