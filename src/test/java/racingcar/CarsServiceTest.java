package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import org.junit.jupiter.api.Test;

class CarsServiceTest {

    @Test
    void makeCars_메서드_사용시_입력한_자동차_이름_수만큼_Map에_저장() {
        // given
        String input = "pobi, nini, pew";

        // when
        Map<Car, Integer> cars = CarsService.makeCars(input);

        // then
        assertThat(cars.size()).isEqualTo(3);
    }

    @Test
    void updateCount_메서드_사용시_입력한_자동차_이름과_일치하는_Key의_Value에_1더한_값_반환() {
        // given
        String input = "pobi, nini, pew";
        Map<Car, Integer> cars = CarsService.makeCars(input);

        // when && then
        for (Car car : cars.keySet()) {
            assertThat(CarsService.updateCount(cars, car)).isEqualTo(1);
        }
    }
}