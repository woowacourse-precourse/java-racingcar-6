package racingcar.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RaceTest {
    @Test
    void 차량_개수_이름_검증_테스트(){
        // given
        String[] carNames = {"car1", "car2", "car3"};
        // when
        Race race = new Race(carNames);
        // then
        List<Car> cars = race.getCars();
        assertThat(cars.get(0).getName()).isEqualTo("car1");
        assertThat(cars.get(1).getName()).isEqualTo("car2");
        assertThat(cars.get(2).getName()).isEqualTo("car3");
    }

}