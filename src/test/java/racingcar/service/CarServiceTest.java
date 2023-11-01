package racingcar.service;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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
            carService.checkCarsName(name1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            carService.checkCarsName(name2);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            carService.checkCarsName(name3);
        });
    }

    @Test
    public void 자동차이름_공백_입력시_예외_처리() {
        // given
        String name1 = " ";
        String name2 = "car1, ";

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            carService.checkCarsName(name1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            carService.checkCarsName(name2);
        });
    }

    @Test
    public void 자동차이름_글자수_예외_처리() {
        // given
        String name = "123456";

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            carService.checkCarsName(name);
        });
    }

    @Test
    public void 자동차이름_중복_예외_처리() {
        // given
        String name1 = "car,car2,car";
        String name2 = "car,           car     ";

        // then
        assertThrows(IllegalArgumentException.class, () -> {
            carService.checkCarsName(name1);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            carService.checkCarsName(name2);
        });
    }

    @Test
    public void 자동차이름_정상입력() {
        // given
        String name = " car ,c a r, car2,car3 ,car4";

        // when
        List<String> result = carService.checkCarsName(name);

        // then
        assertThat(result).containsExactly("car", "c a r", "car2", "car3", "car4");
    }
}