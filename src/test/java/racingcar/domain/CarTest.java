package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class CarTest {
    private Car car;

    @BeforeEach
    void init() {
        car = Car.create("test");
    }

    @DisplayName("4 미만을 뽑은 경우 멈춘다. currentScore = 0 이다")
    @Test
    void playTest1() {
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(2);

            car.play();
            assertThat(car.getCurrentScore()).isEqualTo(0);
            assertThat(car.getCumulativeScoreList()).containsExactly(0);
        }
    }

    @DisplayName("4 이상을 뽑은 경우 전진한다. currentScore = 1 이다")
    @Test
    void playTest2() {
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt())).thenReturn(5);

            car.play();
            assertThat(car.getCurrentScore()).isEqualTo(1);
            assertThat(car.getCumulativeScoreList()).containsExactly(1);
        }
    }

    @DisplayName("2, 4, 7 순서로 뽑으면 멈춤, 전진, 전진이다.")
    @Test
    void playTest3() {
        try (final MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(2)
                    .thenReturn(4)
                    .thenReturn(7);

            //첫번째 라운드 : 2 뽑음 -> 멈춤
            car.play();
            assertThat(car.getCurrentScore()).isEqualTo(0);
            assertThat(car.getCumulativeScoreList()).containsExactly(0);

            //두번째 라운드 : 4 뽑음 -> 전진
            car.play();
            assertThat(car.getCurrentScore()).isEqualTo(1);
            assertThat(car.getCumulativeScoreList()).containsExactly(0, 1);

            //세번째 라운드 : 7 뽑음 -> 전진
            car.play();
            assertThat(car.getCurrentScore()).isEqualTo(2);
            assertThat(car.getCumulativeScoreList()).containsExactly(0, 1, 2);
        }
    }
}