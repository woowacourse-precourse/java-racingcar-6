package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("car 객체 생성 Test")
    void newCarTest() {
        String name = "sona";
        Car car = new Car(name);

        assertThat(car).hasFieldOrPropertyWithValue("name", name)
                .hasFieldOrPropertyWithValue("position", 0);
    }

    @Test
    @DisplayName("car Move 테스트 - 전진")
    void inputNumber_ThenCarMoved() {
        String name = "sona";
        Car car = new Car(name);
        int move = 5;

        car.move(move);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("car Move 테스트 - 멈춤")
    void inputNumber_ThenCarStop() {
        String name = "sona";
        Car car = new Car(name);
        int move = 2;

        car.move(move);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("포지션 값을 문자열 - 로 표현하여 반환")
    void checkPositionToString() {
        String name = "sona";
        Car car = new Car(name);
        for (int i = 1; i <= 4; i++) {
            car.move(5);
        }
        String postionToString = car.getPositionString();

        assertThat(postionToString).isEqualTo("----");
    }
}