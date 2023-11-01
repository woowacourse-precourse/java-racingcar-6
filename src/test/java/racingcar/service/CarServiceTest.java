package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {
    private static CarService carService;
    private static Car car;

    @BeforeEach
    void initEach(){
        carService = new CarService();
        car = new Car();
    }

    @Test
    void 차_이름_글자수_예외_발생() {
        //given
        final String input = "pobi,javaji";

        //when

        //then
        assertThatThrownBy(() -> carService.setCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 1자 이상 5자 이하만 가능합니다.");
    }

    @Test
    void 차_이름_입력_테스트() {
        //given
        final String input = "pobi,woni";

        //when
        final List<Car> cars = carService.setCars(input);

        //then
        Car car1 = cars.get(0);
        Car car2 = cars.get(1);
        assertThat(car1.getName()).isEqualTo("pobi");
        assertThat(car2.getName()).isEqualTo("woni");
    }
}