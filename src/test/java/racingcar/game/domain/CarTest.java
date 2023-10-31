package racingcar.game.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {
    @Test
    @DisplayName("Car의 메서드 go() 와 compareMileage() 가 정상적으로 작동하는지 확인한다")
    void go_And_compareMileage() {
        var car1 = new Car("1", () -> true);
        var car2 = new Car("2", () -> true);

        assertThat(car1.compareMileage(car2)).isEqualTo(0);

        car1.go();
        assertThat(car1.compareMileage(car2)).isGreaterThan(0);

        car2.go();
        car2.go();
        assertThat(car1.compareMileage(car2)).isLessThan(0);

        car1.go();
        assertThat(car1.compareMileage(car2)).isEqualTo(0);
    }

    @Test
    @DisplayName("toString() 이 예상한 바와 같이 작동하는지 확인한다")
    void testToString() {
        var car = new Car("cloudchamb3r", () -> true);

        assertThat(car.toString()).isEqualTo("cloudchamb3r : ");

        car.go();
        assertThat(car.toString()).isEqualTo("cloudchamb3r : -");

        car.go();
        assertThat(car.toString()).isEqualTo("cloudchamb3r : --");

        car.go();
        assertThat(car.toString()).isEqualTo("cloudchamb3r : ---");

        car.go();
        assertThat(car.toString()).isEqualTo("cloudchamb3r : ----");

        car.go();
        assertThat(car.toString()).isEqualTo("cloudchamb3r : -----");
    }
}