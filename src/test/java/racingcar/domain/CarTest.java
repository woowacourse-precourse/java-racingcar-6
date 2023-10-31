package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    public void 자동차_이름이_5글자보다_짧으면_정상적으로_실행된다() {
        assertThatCode(() -> {
            new Car("short");
        }).doesNotThrowAnyException();
    }

    @Test
    public void 자동차_이름이_5글자보다_길면_예외를_던진다() {
        String longName = "longName";

        assertThatThrownBy(() -> {
            new Car(longName);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 랜덤_넘버가_4이상이면_전진한다() {
        Car car = new Car("car");
        car.move(4);

        assertThat(car.getPosition().getPosition()).isEqualTo(1);
    }

    @Test
    public void 랜덤_넘버가_4미만미면_멈춘다() {
        Car car = new Car("car");
        car.move(3);

        assertThat(car.getPosition().getPosition()).isEqualTo(0);
    }
}