package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

    @DisplayName("자동차 이름은 중복으로 사용될 수 없다.")
    @Test
    void isDifferentCarName() throws Exception{
        //given
        String racingCarName = "pobi";
        Car car = new Car(racingCarName);
        
        List<Car> cars = List.of(car, car);

        //when //then
        Assertions.assertThatThrownBy(() -> new Cars(cars))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 중복으로 사용될 수 없습니다.");
    }

}