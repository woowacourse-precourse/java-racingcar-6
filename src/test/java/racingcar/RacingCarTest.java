package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RacingCarTest {

    @Test
    void 자동차_생성() {
        RacingCar racingCar = new RacingCar("jihun");

        assertEquals("jihun", racingCar.getName());
    }

    @Test
    void 자동차_이름은_5자이하_예외_처리() {
        assertThatThrownBy(() -> new RacingCar("jihun_woowa"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @CsvSource({"4", "5", "6", "7", "8", "9"})
    @ParameterizedTest
    void 랜덤값이_4이상이면_자동차_전진(int inputNumber) {
        RacingCar racingCar = new RacingCar("jihun");
        racingCar.move(inputNumber);

        assertEquals(1, racingCar.getDistance());
    }

    @CsvSource({"0", "1", "2", "3"})
    @ParameterizedTest
    void 랜덤값이_4미만이면_자동차_정지(int inputNumber) {
        RacingCar racingCar = new RacingCar("jihun");
        racingCar.move(inputNumber);

        assertEquals(0, racingCar.getDistance());
    }
}