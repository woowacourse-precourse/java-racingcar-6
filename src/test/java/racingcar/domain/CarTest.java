package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void Car_이름을_가져온다() {
        Car car = new Car("자동차");
        String result = car.getName();
        String expected = "자동차";
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void Car_위치를_가져온다() {
        Car car = new Car("자동차");

        int result = car.getLocation();

        int expected = 0;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void Car_전진한다() {
        Car car = new Car("자동차");

        car.go();
        car.go();

        int result = car.getLocation();
        int expected = 2;
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void Car_객체를_비교한다() {
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        Car car3 = new Car("Car3");

        car1.go();

        int result1 = car1.compareTo(car2);
        int result2 = car2.compareTo(car1);
        int result3 = car2.compareTo(car3);

        Assertions.assertThat(result1).isGreaterThan(0);
        Assertions.assertThat(result2).isLessThan(0);
        Assertions.assertThat(result3).isEqualTo(0);
    }
}