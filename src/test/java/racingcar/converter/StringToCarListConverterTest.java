package racingcar.converter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class StringToCarListConverterTest {

    @Test
    @DisplayName("입력된 문자열을 쉼표(,)를 기준으로 분리할 수 있다.")
    void convert() {
        Converter<String, List<Car>> converter = new StringToCarListConverter();
        List<Car> result = converter.convert("pobi,woni,jun");

        assertThat(result).containsExactly(new Car("pobi"), new Car("woni"), new Car("jun"));
    }
}