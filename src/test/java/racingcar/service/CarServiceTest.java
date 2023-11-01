package racingcar.service;

import org.junit.jupiter.api.Test;
import racingcar.object.Car;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {

    CarService carService = new CarService();

    @Test
    public void 자동차이름_입력_없음_예외_처리() {
        // given
        String name1 = "";
        String name2 = ",";
        String name3 = "car1,";

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            carService.checkCarsNameLength(name1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            carService.checkCarsNameLength(name2);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            carService.checkCarsNameLength(name3);
        });
    }


}