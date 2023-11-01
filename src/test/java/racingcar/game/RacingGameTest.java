package racingcar.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.util.RandomNumberGenerator;

class RacingGameTest {
    RacingGame racingGame;
    InputStream in;
    OutputStream out;

    @DisplayName("게임이 정확하게 실행되고 종료되는지를 확인합니다.")
    @Test
    void startGame_IsReturnExpectedResult() {
        in = new ByteArrayInputStream("sang,jin,abc\n5".getBytes());
        System.setIn(in);

        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        RandomNumberGenerator randomNumberGenerator = mock(RandomNumberGenerator.class);

        when(randomNumberGenerator.createRandomNumberListInRange(0, 9, 3))
                .thenReturn(List.of(5, 4, 3))
                .thenReturn(List.of(1, 4, 9))
                .thenReturn(List.of(4, 5, 9))
                .thenReturn(List.of(0, 1, 8))
                .thenReturn(List.of(2, 6, 7));

        String expectedOutput = """
                경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
                시도할 회수는 몇회인가요?
                sang : -
                jin : -
                abc :\s
                                
                sang : -
                jin : --
                abc : -
                                
                sang : --
                jin : ---
                abc : --
                                
                sang : --
                jin : ---
                abc : ---
                                
                sang : --
                jin : ----
                abc : ----
                                
                최종 우승자 : jin, abc
                """;

        racingGame = new RacingGame(randomNumberGenerator);
        racingGame.startGame();
        assertThat(out.toString()).isEqualTo(expectedOutput);
    }
}