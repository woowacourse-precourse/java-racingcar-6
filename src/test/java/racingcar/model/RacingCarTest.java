package racingcar.model;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private RacingCar racingCar;

    @BeforeEach
    void before() {
        racingCar = RacingCar.createRacingCar("infi");
    }

    @Test
    @DisplayName("자동차 생성 후 이름 확인")
    void createRacingCarAndGetNameTest() {
        assertThat(racingCar.getName()).isEqualTo("infi");
    }

    @Test
    @DisplayName("자동차 생성 후 초기 위치 확인")
    void createRacingCarAndGetPositionTest() {
        assertThat(racingCar.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차 전진 성공 확인")
    void successTryMoveTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    racingCar.tryMove();
                    assertThat(racingCar.getName()).isEqualTo("infi");
                    assertThat(racingCar.getPosition()).isEqualTo(1);
                    assertThat(racingCar.getResult()).isEqualTo("infi : -");
                },
                MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("자동차 전진 실패 확인")
    void failureTryMoveTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    racingCar.tryMove();
                    assertThat(racingCar.getName()).isEqualTo("infi");
                    assertThat(racingCar.getPosition()).isEqualTo(0);
                    assertThat(racingCar.getResult()).isEqualTo("infi : ");
                },
                STOP
        );
    }

    @Override
    public void runMain() {
    }
}
