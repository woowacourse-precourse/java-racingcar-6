package racingcar.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import racingcar.CaptureBaseTest;
import racingcar.utils.randomGenerator.RandomNumberGenerator;
import racingcar.utils.writer.ConsoleWriter;
import racingcar.utils.writer.Writer;

class RacingCarGameTest extends CaptureBaseTest {

    public static final String PLAYER1 = "player1";
    public static final String PLAYER2 = "player2";
    public static final CharSequence[] RESULT_SEQUENCES = {
        "실행 결과",
        PLAYER1 + " : -",
        PLAYER2 + " : -",
        PLAYER1 + " : --",
        PLAYER2 + " : --",
        "최종 우승자 : " + PLAYER1 + ", " + PLAYER2};
    public static final String CAR_NAME_CONTEXT = PLAYER1 + ", " + PLAYER2;

    RandomNumberGenerator mockRandomNumberGenerator = mock(RandomNumberGenerator.class);
    Writer writer = new ConsoleWriter();

    @Test
    void 플레이_테스트() {
        // given
        RacingCarGame racingCarGame = new RacingCarGame(mockRandomNumberGenerator, writer);
        when(mockRandomNumberGenerator.generateRandomSingleDigit()).thenReturn(4);

        // when
        racingCarGame.play(CAR_NAME_CONTEXT, 2);

        // then
        assertThat(output()).contains(RESULT_SEQUENCES);
    }

}