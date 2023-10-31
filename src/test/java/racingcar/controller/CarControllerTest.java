package racingcar.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.dto.CarsDto;
import racingcar.dto.WinnerDto;


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

        // when-then
        assertThatThrownBy(() -> carController.generateCars(inputStr))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("레이스 n번 실행 및 우승자 출력 테스트")
    @Test
    void gameStartNTimesTest() {
        // given
        String times = "3";
        String[] names = {"철수", "짱구", "맹구"};
        Car[] cars = new Car[names.length];
        for (int i=0; i< names.length; i++) {
            cars[i] = new Car(names[i]);
        }
        CarsDto carsDto = new CarsDto(cars);

        // when
        WinnerDto winnerDto = carController.gameStartNTimes(carsDto, times);

        // then
        String[] winners = winnerDto.names();
        assertThat(winners).isNotEmpty();
        for (String name : winners) {
            assertThat(names).contains(name);
        }
    }
}
