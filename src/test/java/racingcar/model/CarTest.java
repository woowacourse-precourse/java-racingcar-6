package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    private Car car = new Car();

    @DisplayName("이름이 널이거나 범위를 벗어나면 예외 발생")
    @Test
    void nameIsNullOrOutOfRange() {
        //Given
        String shortName = "";
        String LongName = "가나다라마";

        //When & Then
        assertThrows(IllegalArgumentException.class, () -> car.lengthValidation(null));
        assertThrows(IllegalArgumentException.class, () -> car.lengthValidation(shortName));
        assertThrows(IllegalArgumentException.class, () -> car.lengthValidation(LongName));
    }

    @DisplayName("무작위 값이 기준 값 이상일 때 전진")
    @Test
    void forwardIfRandomIsOverStandard() {
        //Given
        int randomValue = 4;

        //When
        car.run(randomValue);

        //Then
        assertEquals(1, car.getDistance());
    }

    @DisplayName("무작위 값이 기준 값 이하일 때 정지")
    @Test
    void stopIfRandomIsUnderStandard() {
        //Given
        int randomValue = 3;

        //When
        car.run(randomValue);

        //Then
        assertEquals(0, car.getDistance());
    }

}
