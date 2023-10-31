package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Cars;

import static org.junit.jupiter.api.Assertions.*;

class ConverterTest {
    @Test
    @DisplayName("컨버터는 차량 이름을 나누어 주어야 한다. 1개의 차량")
    void 이름_3개를_1개의_객체로_변환() {
        String names = "First";

        Cars cars = Converter.stringToCar(names);

        assertNotNull(cars);
        assertEquals(
                """
                        First :\s
                        """
                , cars.printPosition());
    }

    @Test
    @DisplayName("컨버터는 차량 이름을 나누어 주어야 한다. 3개의 차량")
    void 이름_3개를_3개의_객체로_변환() {
        String names = "First,Secon,Third";

        Cars cars = Converter.stringToCar(names);

        assertNotNull(cars);
        assertEquals(
                """
                        First :\s
                        Secon :\s
                        Third :\s
                        """
                , cars.printPosition());
    }

    @Test
    @DisplayName("컨버터는 이름이 5 초과이면 오류가 발생해야한다.")
    void 이름이_5초과_익셉션_발생() {
        String names = "abcdef";

        assertThrows(IllegalArgumentException.class, () -> Converter.stringToCar(names));
    }

    @Test
    @DisplayName("컨버터는 이름이 비어있으면 오류가 발생해야한다.")
    void 이름이_비어있으면_익셉션_발생() {
        String names = "";

        assertThrows(IllegalArgumentException.class, () -> Converter.stringToCar(names));
    }
}