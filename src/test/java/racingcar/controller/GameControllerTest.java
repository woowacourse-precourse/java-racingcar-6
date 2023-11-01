package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.MockedStatic;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class GameControllerTest {
    GameController gameController;
    final PrintStream standardOut = System.out;
    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final int GO = 9;
    final int STOP = 3;

    @BeforeAll
    public void init() {
        gameController = GameController.getInstance();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterAll
    public void afterAll() {
        System.setOut(standardOut);
    }

    @Test
    void 레이스_테스트_1() {
        try (MockedStatic<Randoms> mockedRandoms = mockStatic(Randoms.class);
             MockedStatic<Console> mockedConsole = mockStatic(Console.class);) {

            given(Console.readLine()).willReturn("car1,car2", "2");
            given(Randoms.pickNumberInRange(anyInt(), anyInt())).willReturn(GO, STOP, GO, STOP);

            gameController.race();

            Assertions.assertThat(outputStreamCaptor.toString()).contains("car1 : -", "car1 : --", "최종 우승자 : car1");
        }
    }

    @Test
    void 레이스_테스트_2() {
        try (MockedStatic<Randoms> mockedRandoms = mockStatic(Randoms.class);
             MockedStatic<Console> mockedConsole = mockStatic(Console.class);) {

            given(Console.readLine()).willReturn("car1,car2", "2");
            given(Randoms.pickNumberInRange(anyInt(), anyInt())).willReturn(GO, GO, GO, GO);

            gameController.race();

            Assertions.assertThat(outputStreamCaptor.toString()).contains("car1 : -", "car1 : --", "car2 : -", "car2 : --", "최종 우승자 : car1, car2");
        }
    }
}
