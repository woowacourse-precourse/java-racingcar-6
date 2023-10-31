package racingcar.car;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

public class CarServiceTest {
    @Test
    void createCarListTestFail() {

        CarService carService = new CarService();

        String input = "pobi,woooni,jun";
        System.setIn(new ByteArrayInputStream(input.getBytes())); // 테스트용 입력 설정

        assertThrows(
                IllegalArgumentException.class,
                () -> carService.createCarList()
        );
    }
}
