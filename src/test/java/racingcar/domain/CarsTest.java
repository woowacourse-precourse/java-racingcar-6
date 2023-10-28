package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    @DisplayName("입력값을 기반으로 자동차를 생성한다.")
    @Test
    void makeCars() {
        // given
        List<String> nameList = List.of("pobi", "lee", "kim");

        // when
        Cars cars = new Cars();
        cars.makeCars(nameList);

        // then
        try {
            Field field = Cars.class.getDeclaredField("cars");
            field.setAccessible(true);
            List<String> carList = (List<String>) field.get(cars);

            assertThat(carList.size()).isEqualTo(3);
            field.setAccessible(false);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}