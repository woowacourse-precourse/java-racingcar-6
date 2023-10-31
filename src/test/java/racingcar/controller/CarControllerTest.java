package racingcar.controller;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarControllerTest {
    private static final List<String> CAR_LIST = new ArrayList<>(Arrays.asList("pobi", "woni", "blur"));
    CarController carController;

    @BeforeEach
    void reset() {
        carController = CarController.createCars(CAR_LIST);
    }

    @Test
    @DisplayName("setCarsName 후 toString 출력 확인")
    void testSetCarsName() {
        assertThat(carController.toString()).isEqualTo("pobi : \nwoni : \nblur : \n");
    }

    @Test
    @DisplayName("우승자 한명 일 경우 chooseWinner() 반환값 확인")
    void testChooseWinner() {
        //given

        carController.ifForwardCars();

        //when
        String winner = carController.chooseWinner();

        assertThat(winner).isEqualTo("woni");
    }

    @Test
    @DisplayName("우승자 세 명 일 경우 chooseWinner() 반환값 확인")
    void testChooseThreeWinner() {
        //given

        carController.ifForwardCars();

        //when
        String winner = carController.chooseWinner();

        assertThat(winner).isEqualTo("pobi, woni, blur");
    }
}