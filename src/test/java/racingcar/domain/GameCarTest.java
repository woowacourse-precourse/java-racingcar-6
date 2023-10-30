package racingcar.domain;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class GameCarTest {

    @Test
    void 차량_생성_성공_테스트() {
        String carName = "붕붕카";

        assertThatCode(() -> new GameCar(carName)).doesNotThrowAnyException();
    }

    @Test
    void 빈_차량_이름_실패_테스트() {
        String emptyCarName = "";

        assertThatThrownBy(() -> new GameCar(emptyCarName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 차량_이름_최대길이_실패_테스트() {
        String exceededCarName = "길이초과차명";

        assertThatThrownBy(() -> new GameCar(exceededCarName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 차량_이동_성공_메소드_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car gameCar = new GameCar("붕붕카");
                    int distance = gameCar.getDistance();

                    gameCar.attemptToMove();

                    assertThat(gameCar.getDistance()).isEqualTo(distance + 1);
                },
                4
        );
    }
    @Test
    void 차량_이동_실패_메소드_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    Car gameCar = new GameCar("붕붕카");
                    int distance = gameCar.getDistance();

                    gameCar.attemptToMove();

                    assertThat(gameCar.getDistance()).isEqualTo(distance);
                },
                3
        );
    }
}