package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class GameTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 자동차_객체_생성_테스트(){
        Racingcar car = new Racingcar("TEST");

        for (int i = 0; i < 10; i++){
            car.upMoveDistance();
        }

        assertThat(car.getName()).isEqualTo("TEST");
        assertThat(car.getMoveDistance()).isEqualTo(10);
    }

    @Test
    void 우승자_1명일_경우_테스트(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("123,abc,ABC", "1");
                    assertThat(output()).contains("123 : -", "abc : ", "ABC : ", "최종 우승자 : 123");
                },
                MOVING_FORWARD, STOP, STOP
        );
    }

    @Test
    void 우승자가_전체일_경우_테스트(){
        assertRandomNumberInRangeTest(
                () -> {
                    run("123,abc,ABC", "1");
                    assertThat(output()).contains("123 : -", "abc : -", "ABC : -", "최종 우승자 : 123, abc, ABC");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
