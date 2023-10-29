package racingcar.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 이름이_NULL이거나_길이가_범위를_벗어나면_예외발생() {
        //Given
        String shortName = "";
        String LongName = "마다가스카르";

        //When & Then
        assertThrows(IllegalArgumentException.class, () -> new Car(null));
        assertThrows(IllegalArgumentException.class, () -> new Car(shortName));
        assertThrows(IllegalArgumentException.class, () -> new Car(LongName));
    }

    @Test
    void 무작위_값이_기준값_이상일_때_1칸_이동() {
        //Given
        Car car = new Car();
        int randomValue = 4;

        //When
        car.run(randomValue);

        //Then
        assertEquals(1, car.getDistance());
    }

    @Test
    void 무작위_값이_기준값_이하일_때_1칸_이동() {
        //Given
        int randomValue = 3;
        Car car = new Car();

        //When
        car.run(randomValue);

        //Then
        assertEquals(0, car.getDistance());
    }

}
