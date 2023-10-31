package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {

    @Test
    void 현재_상태를_실행_결과와_같이_출력() {
        Car testCar = new Car("jun");

        for (int i = 0; i < 5; i++) { // 5번 이동
            testCar.moveForward();
        }

        for (int i = 0; i < 2; i++) { // 2번 멈춤
            testCar.stop();
        }

        assertThat(testCar.toString()).isEqualTo("jun : -----"); // toString() 생략 불가
    }
}