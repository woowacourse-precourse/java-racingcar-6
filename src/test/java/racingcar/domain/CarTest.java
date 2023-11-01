package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    void 자동차_이름_반환() {
        Car car = new Car("jane");
        assertThat(car.getName()).isEqualTo("jane");
    }

    @Test
    void 자동차_진행상황_비교() {
        Car car1 = new Car("harry");
        Car car2 = new Car("john");
        Car car3 = new Car("emliy");
        car1.judgmentCarMove(4);
        car2.judgmentCarMove(3);
        car3.judgmentCarMove(3);

        int result1 = car1.compareTo(car2);
        int result2 = car2.compareTo(car1);
        int result3 = car2.compareTo(car3);

        assertThat(result1).isGreaterThan(0);
        assertThat(result2).isLessThan(0);
        assertThat(result3).isEqualTo(0);
        assertThat(car1.isSameProgress(car2)).isFalse();
        assertThat(car2.isSameProgress(car3)).isTrue();
    }

    @Test
    void 자동차_이름과_진행상황_반환() {
        Car car = new Car("woni");
        car.judgmentCarMove(4);
        assertThat(car.getNameAndProgress()).isEqualTo("woni : -");
    }
}
