package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RacingCarGameTest extends NsTest {
    private RacingCarGame racingCarGame;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        racingCarGame = new RacingCarGame();
    }

    @Test
    @DisplayName("RacingCarGame의 play 메서드 테스트")
    void play() {
        // given
        MoveForwardConditioner moveForwardConditioner = mock(MoveForwardConditioner.class);
        InputArgumentsHandler inputArgumentsHandler = mock(InputArgumentsHandler.class);
        when(inputArgumentsHandler.inputCars()).thenReturn(List.of(new Car("pobi", 5), new Car("woni", 3)));
        when(inputArgumentsHandler.inputRoundNumbers()).thenReturn(5);
        racingCarGame.setup(moveForwardConditioner, inputArgumentsHandler);

        // when
        racingCarGame.play();

        // then
        String consoleOutput = outContent.toString();
        assertThat(consoleOutput).contains("실행 결과");
    }

    @Test
    @DisplayName("RacingCarGame의 showAwards 메서드 테스트")
    void showAwards() {
        // given
        MoveForwardConditioner moveForwardConditioner = mock(MoveForwardConditioner.class);
        InputArgumentsHandler inputArgumentsHandler = mock(InputArgumentsHandler.class);
        when(inputArgumentsHandler.inputCars()).thenReturn(List.of(new Car("pobi", 5), new Car("woni", 3)));
        when(inputArgumentsHandler.inputRoundNumbers()).thenReturn(5);
        racingCarGame.setup(moveForwardConditioner, inputArgumentsHandler);

        // when
        racingCarGame.showAwards();

        // then

        String consoleOutput = outContent.toString();
        assertThat(consoleOutput).contains("최종 우승자 : ");
    }

    @Override
    protected void runMain() {
    }
}
