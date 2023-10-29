package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("Car가 제대로 생성 되는지 확인")
    public void testCarCreate() {
        Car car = new Car(List.of("Car1"));
        assertEquals("Car1", car.getName());
        assertEquals(0, car.getPosition());
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
