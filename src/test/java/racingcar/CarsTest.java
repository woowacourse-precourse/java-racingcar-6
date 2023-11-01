package racingcar;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Cars;

public class CarsTest {
    @Test
    @DisplayName("::예외 없이 Cars 객체 생성에 성공한다")
    void creatCars_WhenInputName_NoException() {
        String names = "nini,jojo,pobi,momo";

        assertDoesNotThrow(() -> {
            Cars cars = Cars.createCarList(names);
        });
    }
}
