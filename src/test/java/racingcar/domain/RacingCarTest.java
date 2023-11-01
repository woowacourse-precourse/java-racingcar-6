package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingCarTest {
    @DisplayName("이름이 1글자 이상 5글자 이하인 경우 정상적으로 작동합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"w", "wl", "wlg", "wlgu", "wlgus", "wltn1", "12345", "12 34", " "})
    void 이름_생성_테스트(String name) {
        Assertions.assertDoesNotThrow(() -> {
            new RacingCar(name);
        });
    }

    @DisplayName("이름이 0글자 이거나 5글자 초과라면 예외가 발생합니다.")
    @ParameterizedTest
    @ValueSource(strings = {"", "abcdef", "abcaaaaaa"})
    void 이름_생성_예외_테스트(String name) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new RacingCar(name);
        });
    }

    @DisplayName("4이상의 숫자이면 전진, 아니면 전진하지 않습니다.")
    @Test
    public void 전진_테스트() {
        RacingCar car = new RacingCar("wlgus");

        car.move(3);
        assertEquals(0, car.count);

        car.move(4);
        assertEquals(1, car.count);

        car.move(5);
        assertEquals(2, car.count);
    }
}
