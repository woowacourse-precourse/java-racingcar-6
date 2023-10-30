package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

class ResultServiceTest {

    @Test
    void decideWinners_메서드_사용시_전진_횟수가_가장_많은_자동차를_우승자로_선정() {
        // given
        Car pobi = new Car("pobi");
        Car nini = new Car("nini");
        Car pew = new Car("pew");

        // when
        Map<Car, Integer> cars = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            cars.put(pobi, 1);
            cars.put(nini, 2);
            cars.put(pew, 3);
        }

        // then
        assertThat(ResultService.decideWinners(cars)).contains(pew.getCar());
        assertThat(ResultService.decideWinners(cars)).doesNotContain(pobi.getCar(), nini.getCar());
    }

    @Test
    void decideWinners_메서드_사용시_전진_횟수가_가장_많은_자동차들을_우승자들로_선정() {
        // given
        Car pobi = new Car("pobi");
        Car nini = new Car("nini");
        Car pew = new Car("pew");

        // when
        Map<Car, Integer> cars = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            cars.put(pobi, 1);
            cars.put(nini, 3);
            cars.put(pew, 3);
        }

        // then
        assertThat(ResultService.decideWinners(cars)).contains(pew.getCar(), nini.getCar());
        assertThat(ResultService.decideWinners(cars)).doesNotContain(pobi.getCar());
    }
}