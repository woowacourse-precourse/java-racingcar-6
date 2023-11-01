package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.generator.MoveRaceNumberGenerator;
import racingcar.generator.StopRaceNumberGenerator;

class CarTest {

    @Test
    void 자동차가_움직이면_더해진_값을_반환() {

        //given
        Car car1 = new Car("car1", "");
        Car car2 = new Car("car1", "-");
        Car car3 = new Car("car1", "--");

        // when
        car1.moveOrStop(new MoveRaceNumberGenerator());
        car2.moveOrStop(new MoveRaceNumberGenerator());
        car3.moveOrStop(new MoveRaceNumberGenerator());

        // then
        Assertions.assertThat(car1.getPosition()).isEqualTo("-");
        Assertions.assertThat(car2.getPosition()).isEqualTo("--");
        Assertions.assertThat(car3.getPosition()).isEqualTo("---");
    }

    @Test
    void 자동차가_움직이지_않으면_값을_그대로_반환() {

        //given
        Car car1 = new Car("car1", "");
        Car car2 = new Car("car1", "-");
        Car car3 = new Car("car1", "--");

        // when
        car1.moveOrStop(new StopRaceNumberGenerator());
        car2.moveOrStop(new StopRaceNumberGenerator());
        car3.moveOrStop(new StopRaceNumberGenerator());

        // then
        Assertions.assertThat(car1.getPosition()).isEqualTo("");
        Assertions.assertThat(car2.getPosition()).isEqualTo("-");
        Assertions.assertThat(car3.getPosition()).isEqualTo("--");
    }
}