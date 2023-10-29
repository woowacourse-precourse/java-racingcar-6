package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CarTest {

    CarList carList = CarList.getInstance();

    @BeforeEach
    void init() {
        String carName = "carName";
        Car.setCar(carName);
    }

    @DisplayName("자동차 객체가 리스트에 정상적으로 add 됐는지 여부 테스트")
    @Test
    void addCarAndCarListTest() {
        //given
        List<Car> cars = carList.getCars();

        //when
        String carName = cars.get(0).getCarName();
        int carLevel = cars.get(0).getLevel();

        //then
        assertThat(cars.size()).isEqualTo(1);
        assertThat(carName).isEqualTo("carName");
        assertThat(carLevel).isEqualTo(0);
    }

    @DisplayName("자동차가 전진했을때 level과 log를 처리하는 로직이 정상적으로 동작하는지 테스트")
    @Test
    void carAdvanceTest() {
        //given
        List<Car> cars = carList.getCars();
        Car car = cars.get(0);

        //when
        car.setLevelAndLog(car);

        //then
        assertThat(car.getLevel()).isEqualTo(1);
        assertThat(car.getCarNameAndLog()).isEqualTo("carName : -");
    }
}