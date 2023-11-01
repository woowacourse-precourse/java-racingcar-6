package racingcar.util;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.constant.TestConstants.MOVING_FORWARD;
import static racingcar.constant.TestConstants.STOP;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import racingcar.Cars;

class WriterTest {

    @Test
    void 게임_진행_결과_출력() {
        Cars cars = 자동차들_생성();
        OutputStream out = 출력_스트림_생성();
        assertRandomNumberInRangeTest(
                () -> {
                    cars.attempt();
                    Writer.cars(cars);
                    assertThat(out.toString())
                            .contains("love : -", "hate : -", "you : ");
                },
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 우승자_출력() {
        Cars cars = 자동차들_생성();
        OutputStream out = 출력_스트림_생성();
        assertRandomNumberInRangeTest(
                () -> {
                    cars.attempt();
                    Writer.winner(cars);
                    assertThat(out.toString())
                            .contains("최종 우승자", "you")
                            .doesNotContain("love", "hate");
                },
                STOP, STOP, MOVING_FORWARD
        );
    }

    private Cars 자동차들_생성() {
        return new Cars(new String[]{"love", "hate", "you"});
    }

    private OutputStream 출력_스트림_생성() {
        OutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        return out;
    }
}