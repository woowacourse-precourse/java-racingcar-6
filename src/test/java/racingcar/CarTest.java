package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @Test
    void move() {
        String name = "move_test";
        int total = 10000;
        double answer = 0.6, error = 0.01;

        Car car = new Car(name);
        for (int i = 0; i < total; i++) {
            car.move();
        }
        int cnt = car.getDistance();

        // 이동 확률이 0.59 ~ 0.61이면 통과
        assertThat(Math.abs((double) cnt / total - answer)).isLessThan(error);
    }

    @Test
    void getStatus_이동_거리가_0() {
        String name = "Hello";
        int distance = 0;
        String answer = "Hello : ";

        Car car = new Car(name, distance);
        String result = car.getStatus();
        assertThat(result).isEqualTo(answer);
    }

    @Test
    void getStatus_이동_거리가_1이상() {
        String name = "World";
        int distance = 3;
        String answer = "World : ---";

        Car car = new Car(name, distance);
        String result = car.getStatus();
        assertThat(result).isEqualTo(answer);
    }
}