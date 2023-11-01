package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import racingcar.input.Input;
import racingcar.output.Output;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;



class RacingCarGameTest {

    private static final String CAR_NAME_USER_INPUT = "pobi,wooni,jun";
    private static final String ROUND_COUNT_USER_INPUT = "2";
    private static final int STOP = 3;
    private static final int FORWARD = 4;

    private RacingCarGame game;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        Output output = new Output();
        Input input = new Input(output);
        WinnerPicker winnerPicker = new WinnerPicker();
        game = new RacingCarGame(output, input, winnerPicker);
    }


    @Test
    void 게임테스트_결과_성공() {
        setOut();
        setInput(CAR_NAME_USER_INPUT + "\n" + ROUND_COUNT_USER_INPUT);

        //given
        try (MockedStatic<Randoms> mock = mockStatic(Randoms.class)) {
            mock.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(STOP, STOP, FORWARD, STOP, FORWARD, FORWARD);  //각 차의 거리가 0  1  2

            game.play();
        }

        String printedOutput = getPrintedOutput();

        assertThat(printedOutput)
                .contains("실행 결과", "pobi : ", "wooni : ", "jun : -", "pobi : ", "wooni : -", "jun : --", "최종 우승자 : jun");
    }

    private void setInput(String userInput) {
        InputStream in = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(in);
    }

    private void setOut() {
        outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
    }

    private String getPrintedOutput() {
        return outputStream.toString();
    }
}