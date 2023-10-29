package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RacingCarTest {
    RacingCar racingCar = new RacingCar();

    @DisplayName("null 입력이면 exception 발생")
    @Test
    void nullInput() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> racingCar.naming(null));
    }

    @DisplayName("빈값 입력이면 exception 발생")
    @Test
    void emptyInput() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> racingCar.naming(""));

    }
    @DisplayName("','를 기준으로 값을 구분")
    @Test
    void splitComma() {
        String input = "1,2";
        List<String> actual = racingCar.naming(input);

        assertThat(actual).isEqualTo(Arrays.asList("1","2"));
    }


}