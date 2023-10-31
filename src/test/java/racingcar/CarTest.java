package racingcar;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;


class CarTest {

    @Test
    void createCar() {
        new Car("pobi");
    }

    @Test
    void inputToCarList_Success() {
        GameUtil.inputToCars("pobi,woni,jun");
    }

    @Test
    void inputToCarList_Fail() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> GameUtil.inputToCars("pobi_AAA,woni,jun"));
    }

    @Test
    void moveCarList() {
        Cars cars = GameUtil.inputToCars("pobi,woni,jun");
        cars.movePosition();
    }

    @Test
    void getCarsInfo() {
        Cars cars = GameUtil.inputToCars("pobi,woni,jun");
        cars.movePosition();
        cars.carList.forEach(car -> {
            System.out.println(car.getInfo());
        });
    }

}