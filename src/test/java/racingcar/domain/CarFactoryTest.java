package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarFactoryTest {
    private CarFactory factory;

    @BeforeEach
    void before() {
        factory = new CarFactory();
    }

    @Test
    @DisplayName("정상적으로 Car 리스트로 변환하는지")
    void 정상적으로_Car_리스트로_변환하는지() throws Exception {
        //given
        List<String> stringList = List.of("이름1", "이름2", "이름3");
        //when
        List<Car> carList = factory.factory(stringList);
        //then
        assertThat(carList.size()).isEqualTo(3);
        assertThat(carList.get(0)).isInstanceOf(Car.class);
        assertThat(carList.get(0).getName()).isEqualTo("이름1");
    }

}