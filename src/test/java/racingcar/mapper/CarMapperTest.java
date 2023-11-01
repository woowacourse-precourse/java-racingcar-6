package racingcar.mapper;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;

public class CarMapperTest {
    @DisplayName("문자열로 이름을 입력 받으면 자동차 리스트로 변환해야 한다.")
    @Test
    void 문자열_자동차_리스트로_변환_기능_테스트() {
        //given
        String names = "jun,seo,park";

        //when
        List<Car> cars = CarMapper.convertToCarList(names);

        //then
        assertThat(cars.size()).isEqualTo(3);
    }
}
