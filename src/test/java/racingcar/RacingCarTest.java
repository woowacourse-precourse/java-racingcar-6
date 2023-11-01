package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import controller.RacingCar;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

public class RacingCarTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전체_자동차_경주를_실행하는_기능_테스트() {
        //given
        RacingCar racingCar = new RacingCar();

        assertRandomNumberInRangeTest(
            () -> {
                //when
                run("yoon,su", "3");
                racingCar.startGame();
                //then
                Assertions.assertThat(output()).contains(
                        "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)",
                        "시도할 회수는 몇회인가요?",
                        "실행 결과",
                        "yoon : -", "su : ",
                        "yoon : -", "su : -",
                        "yoon : --", "su : -",
                        "최종 우승자 : yoon"
                );
            },
                MOVING_FORWARD, STOP,
                STOP, MOVING_FORWARD,
                MOVING_FORWARD, STOP
        );
    }

    @Override
    protected void runMain() {

    }
}
