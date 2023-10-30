package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class RandomManagerTest {
    @Test
    void isMovingCar() {
        int total = 10000, cnt = 0;
        double answer = 0.6, error = 0.01;

        for (int i = 0; i < total; i++) {
            boolean result = RandomManager.isMovingCar();
            if (result) {
                cnt++;
            }
        }

        // 이동 확률이 0.59 ~ 0.61이면 통과
        assertThat(Math.abs((double) cnt / total - answer)).isLessThan(error);
    }
}