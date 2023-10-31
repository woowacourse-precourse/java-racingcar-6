package racingcar.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarTest {
    @Test
    void 자동차_전진_테스트_4이상이면_전진() {
        Car car = new Car("car");

        while (car.getPosition() == 0) {
            car.move();
        }
        assertTrue(car.getPosition() > 0);
    }
    @Test
    void 자동차_전진_테스트_4미만이면_정지() {
        Car car = new Car("car");

        while (true) {
            int initialPosition = car.getPosition(); // 초기 위치 저장
            car.move();
            int finalPosition = car.getPosition(); // 최종 위치 저장

            if (initialPosition == finalPosition) {
                break; // 만약 초기 위치와 최종 위치가 같다면 루프를 나옴
            }
        }
    }
}