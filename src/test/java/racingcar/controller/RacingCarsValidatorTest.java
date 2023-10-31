package racingcar.controller;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarsValidatorTest {
    RacingCarsValidator racingCarsValidator = new RacingCarsValidator();

    @Test
    void validateNamesTest() {
        String names = "abc,def";
        List<String> namesSplit = racingCarsValidator.validateNames(names);
        assertThat(namesSplit).containsExactly("abc", "def");
    }

    @Test
    void validateEmptyNameTest() {
        assertThatThrownBy(() -> {
            String names = "";
            List<String> namesSplit = racingCarsValidator.validateNames(names);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateEmptyNameTest2() {
        assertThatThrownBy(() -> {
            String names = "infi,,kei";
            List<String> namesSplit = racingCarsValidator.validateNames(names);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateEmptyNameTest3() {
        assertThatThrownBy(() -> {
            String names = ",infi,kei";
            List<String> namesSplit = racingCarsValidator.validateNames(names);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateEmptyNameTest4() {
        assertThatThrownBy(() -> {
            String names = "infi,kei,";
            List<String> namesSplit = racingCarsValidator.validateNames(names);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateEmptyNameTest5() {
        assertThatThrownBy(() -> {
            String names = ",,,,,";
            List<String> namesSplit = racingCarsValidator.validateNames(names);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
