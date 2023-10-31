package racingcar.domain;

import org.junit.jupiter.api.Test;
import racingcar.domain.dto.CarResult;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    void 랜덤한_숫자가_4이상일_경우_자동차_전진() {
        Car car = new Car("pobi");
        CarResult move = car.move(4);
        assertAll(
                () -> assertThat(move.name()).isEqualTo(new Name("pobi")),
                () -> assertThat(move.position()).isEqualTo(new Position(1)));
    }

    @Test
    void 랜덤한_숫자가_4미만일_경우_자동차_정지() {
        Car car = new Car("pobi");
        CarResult move = car.move(3);
        assertAll(
                () -> assertThat(move.name()).isEqualTo(new Name("pobi")),
                () -> assertThat(move.position()).isEqualTo(new Position(0)));
    }

    @Test
    void 같은_자동차인지_판별한다(){
        assertThat(new Car("pobi")).isEqualTo(new Car("pobi"));
    }
}