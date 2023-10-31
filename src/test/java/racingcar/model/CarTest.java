package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 객체_생성_확인() {
        Car car1 = new Car("Eric");
        assertThat(car1).isNotNull();
        assertThat(car1.getName()).isEqualTo("Eric");
        assertThat(car1.getProgress()).isEqualTo(0);
    }

    @Test
    void 차량_이동_확인() {
        Car carTest = new Car("glory");
        carTest.move();
        assertThat(carTest.getProgress() == 1 || carTest.getProgress() == 0).isTrue();
    }

    @Test
    void 같은지_비교() {
        Car car1 = new Car("eric");
        Car car2 = new Car("readable-ko");
        assertThat(car1.isSame(car2)).isTrue();
    }

    @Test
    void compare_함수_작동() {
        Car car1 = new Car("eric");
        Car car2 = new Car("readable-ko");
        assertThat(car1.compareTo(car2)).isEqualTo(0);
    }
}
