package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarsValidatorTest {
    RacingCarsValidator racingCarsValidator = new RacingCarsValidator();

    @Test
    @DisplayName("이름 검증에 대한 결과 확인")
    void validateNamesTest() {
        String names = "abc,def";
        List<String> namesSplit = racingCarsValidator.validateNames(names);
        assertThat(namesSplit).containsExactly("abc", "def");
    }

    @Test
    @DisplayName("긴 문자열 이름에 대한 예외 처리 확인")
    void validateLongNameTest() {
        assertThatThrownBy(() -> {
            String names = "banana,apple";
            List<String> namesSplit = racingCarsValidator.validateNames(names);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("긴 문자열 이름에 대한 예외 처리 확인 2")
    void validateLongNameTest2() {
        assertThatThrownBy(() -> {
            String names = "infikei";
            List<String> namesSplit = racingCarsValidator.validateNames(names);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("빈 문자열 이름에 대한 예외 처리 확인")
    void validateEmptyNameTest() {
        assertThatThrownBy(() -> {
            String names = "";
            List<String> namesSplit = racingCarsValidator.validateNames(names);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("빈 문자열 이름에 대한 예외 처리 확인 2")
    void validateEmptyNameTest2() {
        assertThatThrownBy(() -> {
            String names = "infi,,kei";
            List<String> namesSplit = racingCarsValidator.validateNames(names);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("빈 문자열 이름에 대한 예외 처리 확인 3")
    void validateEmptyNameTest3() {
        assertThatThrownBy(() -> {
            String names = ",infi,kei";
            List<String> namesSplit = racingCarsValidator.validateNames(names);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("빈 문자열 이름에 대한 예외 처리 확인 4")
    void validateEmptyNameTest4() {
        assertThatThrownBy(() -> {
            String names = "infi,kei,";
            List<String> namesSplit = racingCarsValidator.validateNames(names);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("빈 문자열 이름에 대한 예외 처리 확인 5")
    void validateEmptyNameTest5() {
        assertThatThrownBy(() -> {
            String names = ",,,,,";
            List<String> namesSplit = racingCarsValidator.validateNames(names);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
