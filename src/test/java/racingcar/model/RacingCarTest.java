package racingcar.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {

    @ParameterizedTest
    @ValueSource(strings = {"poni5", "woni5", "12345"})
    void validate_5글자이상_이름들을_받으면_예외를_반환한다(String name_len5) {
        assertThatThrownBy(() -> RacingCar.from(name_len5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"poni5", "woni5", "12345"})
    void validate_쉼표포함_이름들을_받으면_예외를_반환한다(String name_comma) {
        assertThatThrownBy(() -> RacingCar.from(name_comma))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validate_빈문자열을_받으면_예외를_반환한다() {
        assertThatThrownBy(() -> RacingCar.from(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

}