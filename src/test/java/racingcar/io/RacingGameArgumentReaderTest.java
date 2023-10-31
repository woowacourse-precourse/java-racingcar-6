package racingcar.io;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RacingGameArgumentReaderTest {

    @Test
    void 자동차_이름를_입력받아서_리스트로_반환한다() {
        //given
        InputReader mockInputReader = mock(InputReader.class);
        when(mockInputReader.readLine()).thenReturn("car1,car2,car3");
        GameArgumentReader gameArgumentReader = new GameArgumentReader(mockInputReader);

        //when
        List<String> carNames = gameArgumentReader.readCarNames();

        //then
        assertThat(carNames).isEqualTo(Arrays.asList("car1", "car2", "car3"));
    }

    @Test
    void 시도_횟수를_입력받아서_반환한다() {
        //given
        InputReader mockInputReader = mock(InputReader.class);
        String input = "5";
        when(mockInputReader.readLine()).thenReturn(input);
        GameArgumentReader gameArgumentReader = new GameArgumentReader(mockInputReader);

        //when
        String attemptNumber = gameArgumentReader.readAttemptNumber();

        //then
        assertThat(attemptNumber).isEqualTo(input);
    }
}