package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.List;

class CarNameTest {

    @Test
    void 자동차_이름_쉼표로_구분_리스트로_반환() {
        // given
        CarName carName = new CarName();
        String name = "car1 , car2,car3 ,car4,test5";

        // when
        List<Car> carList = carName.splitUserInputCarName(name);

        // then
        assertThat(carList).extracting("name").
                containsExactly("car1", "car2", "car3", "car4", "test5");
    }

}