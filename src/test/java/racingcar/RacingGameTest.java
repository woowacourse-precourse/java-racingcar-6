package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.api.Test;

class RacingGameTest {

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
        assertThrows(IllegalArgumentException.class, () -> {
            RacingGame racingGame = new RacingGame();
        });

        Console.close();
    }

    @Test
    void 참가자_명단_공백_테스트() {
        //given
        final byte[] buf = "AA,BB,,BB\n4".getBytes();
        System.setIn(new ByteArrayInputStream(buf));

        //when & then
        assertThrows(IllegalArgumentException.class, () -> {
            RacingGame racingGame = new RacingGame();
        });

        Console.close();
    }

}