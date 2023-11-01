package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("Car가 제대로 생성 되는지 확인")
    public void testCarCreate() {
        Car car1 = new Car(List.of("Car1"));
        Car car2 = new Car(List.of("Car2"));
        Car car3 = new Car(List.of("Car3"));

        assertThat(car1.getName()).isEqualTo("Car1");
        assertThat(car1.getPosition()).isEqualTo(0);

        assertThat(car2.getName()).isEqualTo("Car2");
        assertThat(car2.getPosition()).isEqualTo(0);

        assertThat(car3.getName()).isEqualTo("Car3");
        assertThat(car3.getPosition()).isEqualTo(0);

    }

    @Test
    @DisplayName("랜덤 값에 따른 전진 테스트")
    public void testCanMove() {
        Car car = new Car(List.of("Car1"));
        car.move(true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤 값에 따른 정지 테스트")
    public void testCannotMove() {
        Car car = new Car(List.of("Car1"));
        car.move(false);
        assertThat(car.getPosition()).isEqualTo(0);
    }

}
