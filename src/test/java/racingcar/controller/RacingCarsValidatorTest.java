package racingcar.controller;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsValidatorTest {
    RacingCarsValidator racingCarsValidator = new RacingCarsValidator();

    @Test
    void validateNamesTest() {
        String names = "abc,def";
        List<String> namesSplit = racingCarsValidator.validateNames(names);
        assertThat(namesSplit).containsExactly("abc", "def");
    }
}
