package racingcar.model;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarsGeneratorTest {

    private final CarsGenerator carsGenerator = new CarsGenerator();

    @ParameterizedTest
    @CsvSource(value = {"pobywoni", "poby,woni,hyukji"}, delimiter = ' ')
    void 자동차_이름이_5글자가_넘는다면_예외를_던진다(final String carNames) {
        assertThatThrownBy(() -> carsGenerator.generate(carNames))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("자동차 이름은 5글자 초과할 수 없다.");
    }

    @Test
    void 사용자_입력을_기반으로_자동차들을_생성한다() {
        // given
        final String carNames = "poby,woni,hyukj";
        final List<String> expected = List.of("poby", "woni", "hyukj");

        // when
        final List<Car> cars = carsGenerator.generate(carNames);
        final List<String> result = cars.stream().map(Car::getName).toList();

        // then
        assertThat(result).isEqualTo(expected);
    }

}