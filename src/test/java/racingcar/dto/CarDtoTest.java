package racingcar.dto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CarDtoTest {
    @ParameterizedTest
    @CsvSource(value = {"apple:0", "melon:3"}, delimiter = ':')
    void 이름과_위치를_인자로_객체를_생성한다(String name, int position) {
        CarDto carDto = CarDto.of(name, position);

        assertThat(carDto.name()).isEqualTo(name);
        assertThat(carDto.position()).isEqualTo(position);
    }
}
