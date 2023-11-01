package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RacingCarTest {

    private RacingCar racingCar;

    @BeforeEach
    void 초기화() {
        racingCar = new RacingCar("jihun");
    }

    @Test
    void 자동차_생성() {
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
        racingCar.move(inputNumber);

        assertEquals(1, racingCar.getDistance());
    }

    @CsvSource({"0", "1", "2", "3"})
    @ParameterizedTest
    void 랜덤값이_4미만이면_자동차_정지(int inputNumber) {
        racingCar.move(inputNumber);

        assertEquals(0, racingCar.getDistance());
    }

    @Test
    void 같은_위치에_있는_자동차_거리_비교() {
        RacingCar otherCar = new RacingCar("pobi");

        racingCar.move(4);
        otherCar.move(5);

        assertTrue(racingCar.isSameDistance(otherCar));
    }

    @Test
    void 다른_위치에_있는_자동차_거리_비교() {
        RacingCar otherCar = new RacingCar("pobi");

        racingCar.move(4);

        assertFalse(racingCar.isSameDistance(otherCar));
    }
}