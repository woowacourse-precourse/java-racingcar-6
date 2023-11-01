package racingcar.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;

public class GameServiceTest {
    @DisplayName("올바른 자동차 이름 입력")
    @Test
    void 유효한_자동차_이름() {
        // given
        List<String> carNames = Arrays.asList("rea", "mei", "jin");

        // when
        Car car = new Car(carNames);

        // then
        Assertions.assertThat(car.getCarName().containsAll(carNames));
    }

    void 중복된_자동차_이름_예외_처리() {

    }


}
