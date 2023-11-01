package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.model.Cars;

class ConverterTest {
    @Test
    void 자동차_이름_문자열을_Cars_객체로_변환한다() {
        String carNames = "pobi,woni,jun";
        Cars cars = Converter.parseCarNames(carNames);
        assertThat(cars.getCars().size()).isEqualTo(3);
    }
}