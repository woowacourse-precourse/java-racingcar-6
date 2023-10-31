package racingcar.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarControllerTest {

    @BeforeEach
    void beforeEach() {
        CarController.cars.clear();
    }

    @AfterEach
    void afterEach() {
        CarController.cars.clear();
    }

    @Test
    @DisplayName("입력받은 자동차 이름별로 자동차 객체 생성하기")
    public void testMakeCar() {
        //given
        String inputCarName = "Car1,Car2,Car3";

        //when
        CarController.makeCar(inputCarName);

        //then
        assertThat(CarController.cars.size()).isEqualTo(3);
        assertThat(CarController.cars.get(0).getName()).isEqualTo("Car1");
        assertThat(CarController.cars.get(1).getName()).isEqualTo("Car2");
        assertThat(CarController.cars.get(2).getName()).isEqualTo("Car3");
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1,22,333,4444,55555,666666",
            ","
    })
    @DisplayName("실패 - 입력받은 자동차 이름별로 자동차 객체 생성하기")
    public void failToMakeCar(String input) {
        //given
        String failToinputCarNames = input;

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> CarController.makeCar(failToinputCarNames));
    }
}