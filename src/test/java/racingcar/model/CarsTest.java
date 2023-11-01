package racingcar.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    private Cars cars;

    @Test
    @DisplayName("Cars가 제대로 생성되었는지 확인한다.")
    void 객체_생성_확인() {
        // Given
        String validNames = "Car1,Car2,Car3";

        // When
        cars = new Cars(validNames);

        // Then
        assertEquals(3, cars.getCars().size());
    }

    @Test
    @DisplayName("빈 String은 예외 처리")
    void 객체_생성시_공백_예외() {
        // Given
        String emptyNames = "";

        // Then
        assertThrows(IllegalArgumentException.class, () -> new Cars(emptyNames));
    }

    @Test
    @DisplayName("중복된 이름은 예외처리")
    void 객체_생성시_중복_예외() {
        // Given
        String duplicateNames = "Car1,Car2,Car1";

        // Then
        assertThrows(IllegalArgumentException.class, () -> new Cars(duplicateNames));
    }

    @Test
    @DisplayName("6글자를 넘는 이름은 예외처리")
    void 객체_생성시_유효한_길이() {
        // Given
        String longName = "ThisNameIsTooLongToBeValid";

        // Then
        assertThrows(IllegalArgumentException.class, () -> new Cars(longName));
    }
}