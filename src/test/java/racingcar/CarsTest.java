package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarsTest {
    Cars cars = new Cars();

    @Test
    @DisplayName("5자를 초과하는 자동차 이름이 입력된 경우 예외 확인")
    void testOverMaxLength() {
        String input = "jeongsu,pobi";
        assertThrows(IllegalArgumentException.class, () ->
                cars.inputCarName(input));
    }

    @Test
    @DisplayName("중복된 자동차 이름이 입력된 경우 예외 확인")
    void testDuplicate() {
        String input = "pobi,woni,pobi";
        assertThrows(IllegalArgumentException.class, () ->
                cars.inputCarName(input));
    }

    @Test
    @DisplayName("자동차 이름에 공백이 입력된 경우 예외 확인")
    void testSpace() {
        String input = "pobi,,woni";
        assertThrows(IllegalArgumentException.class, () ->
                cars.inputCarName(input));
    }
}
