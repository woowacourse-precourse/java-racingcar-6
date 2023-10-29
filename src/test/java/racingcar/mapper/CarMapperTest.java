package racingcar.mapper;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

public class CarMapperTest {
    @DisplayName("문자열을 쉼표로 구분하여 자동차 리스트로 반환해야 한다.")
    @Test
    void 문자열_자동차_리스트로_변환_기능_테스트() {
        //given
        String names = "jun,pobi";

        //when
        List<Car> cars = CarMapper.stringToCarList(names);

        //then
        assertThat(cars.size()).isEqualTo(2);
    }
}
