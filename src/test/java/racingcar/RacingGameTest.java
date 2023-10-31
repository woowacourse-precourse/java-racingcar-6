package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

class RacingGameTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void instance_생성_테스트() {
        //given
        final byte[] buf = "Aa,BB,C\n4".getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        //when
        RacingGame racingGame = new RacingGame();
        Console.close();

        //then
        assertThat(racingGame).isNotNull();
        assertThat(racingGame).isInstanceOf(RacingGame.class);
    }

    @Test
    void 참가자_명단_중복_테스트() {
        //given
        final byte[] buf = "AA,BB,CC,BB\n4".getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        //when & then
        assertThrows(IllegalArgumentException.class, RacingGame::new);

        Console.close();
    }

    @Test
    void 참가자_명단_공백_테스트() {
        //given
        final byte[] buf = "AA,BB,,BB\n4".getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        //when & then
        assertThrows(IllegalArgumentException.class, RacingGame::new);

        Console.close();
    }

    @Test
    void 참가자_명단_길이_테스트() {
        //given
        final byte[] buf = "AA,BB,CCCCCC,DD\n4".getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        //when & then
        assertThrows(IllegalArgumentException.class, RacingGame::new);

        Console.close();
    }

    @Test
    void 우승자_중복_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("ZZ3n,park", "1");
                    assertThat(output()).contains("ZZ3n : -", "park : -", "최종 우승자 : ZZ3n, park");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}