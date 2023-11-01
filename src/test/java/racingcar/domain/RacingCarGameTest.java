package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.ToStringBuilder;
import org.mockito.MockedStatic;
import racingcar.input.Input;
import racingcar.output.Output;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class RacingCarGameTest {
    private Output output;
    private Input input;
    private WinnerPicker winnerPicker;
    private RacingCarGame game;
    private ByteArrayOutputStream outputStream;
    private static final String CAR_NAMES_PROMPT = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_COUNT_PROMPT = "시도할 회수는 몇회인가요?";
    private static final String CAR_NAME_USER_INPUT = "pobi,wooni,jun";
    private static final String ROUND_COUNT_USER_INPUT = "2";
    private static final int STOP = 3;
    private static final int FORWARD = 4;

    @BeforeEach
    void setUp() {
        output = new Output();
        input = new Input(output);
        winnerPicker = new WinnerPicker();
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
                .contains("실행결과", "pobi : ", "wooni : ", "jun : -", "pobi : ", "wooni : -", "jun : --", "최종 우승자 : jun");
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