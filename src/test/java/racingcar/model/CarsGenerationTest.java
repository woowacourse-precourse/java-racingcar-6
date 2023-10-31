package racingcar.model;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.exception.InputErrorCode.INVALID_CAR_NAME_SIZE;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarsGenerationTest {

    @ParameterizedTest
    @CsvSource(value = {"pobywoni", "poby,woni,hyukji"}, delimiter = ' ')
    void 자동차_이름이_5글자가_넘는다면_예외를_던진다(final String carNames) {
        assertThatThrownBy(() -> Cars.from(carNames))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(INVALID_CAR_NAME_SIZE.getMessage());
    }

    @Test
    void 사용자_입력을_기반으로_자동차들을_생성한다() {
        // given
        final String carNames = "poby,woni,hyukj";
        final List<String> expected = List.of("poby", "woni", "hyukj");

        // when
        final Cars cars = Cars.from(carNames);

        // then
        final List<String> result = cars.getCarList().stream().map(Car::getName).toList();
        assertThat(result).isEqualTo(expected);
    }

}