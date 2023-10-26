package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.CarController;
import racingcar.domain.Car;
import racingcar.dto.CarsDto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarControllerTest {

    private static final CarController carController = new CarController();

    @DisplayName("자동차 생성 테스트")
    @Test
    void generateCarsNormalTest() {
        // given
        String inputStr = "철수, 신짱구 , 유리 유리";

        // when
        CarsDto carsDto = carController.generateCars(inputStr);

        // then
        String[] names = {"철수", "신짱구", "유리 유리"};
        Car[] cars = carsDto.cars();
        for (int idx=0; idx<cars.length; idx++) {
            assertThat(cars[idx].ownerOfCar()).isEqualTo(names[idx]);
        }
    }

    @DisplayName("자동차 생성 5글자 초과 예외 테스트")
    @Test
    void generateCarsExceptionTest1() {
        // given
        String inputStr = "철수, 신짱구 , 유리유리유리";

        // when
        assertThatThrownBy(() -> carController.generateCars(inputStr))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자동차 생성 공백 예외 테스트")
    @Test
    void generateCarsExceptionTest2() {
        // given
        String inputStr = "철수,  , 유리";

        // when
        assertThatThrownBy(() -> carController.generateCars(inputStr))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
