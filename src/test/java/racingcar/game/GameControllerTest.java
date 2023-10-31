package racingcar.game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.io.InputReader;

class GameControllerTest {

    private OutputStream captor;

    @BeforeEach
    void init() {
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @Test
    void 사용자로부터_자동차_이름과_시도_횟수를_입력받는다() {
        // given
        String carNames = "car1,car2,car3";
        List<String> carNameList = Arrays.stream(carNames.split(",")).toList();
        String attemptNumber = "5";

        InputReader mockInputReader = mock(InputReader.class);
        when(mockInputReader.readLine())
                .thenReturn(carNames)
                .thenReturn(attemptNumber);

        GameController gameController = new GameController(mockInputReader);

        // when
        gameController.setup();

        // then
        assertThat(gameController.getGameArgument().getCarNames()).isEqualTo(carNameList);
        assertThat(gameController.getGameArgument().getAttemptInput()).isEqualTo(attemptNumber);
    }

    @Test
    void 게임을_시작하고_게임_결과를_출력한다() {
        //given
        InputReader mockInputReader = mock(InputReader.class);
        when(mockInputReader.readLine()).thenReturn("car1,car2,car3", "5");

        GameController gameController = new GameController(mockInputReader);
        gameController.setup();

        //when
        gameController.start();

        //then
        assertThat(output()).contains("최종 우승자 : ");

    }

    private String output() {
        return captor.toString().trim();
    }
}