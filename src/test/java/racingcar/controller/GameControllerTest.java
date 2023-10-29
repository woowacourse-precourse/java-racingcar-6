package racingcar.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import racingcar.domain.Attempt;
import racingcar.domain.Car;
import racingcar.domain.RandomNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

class GameControllerTest {

    private final static PrintStream stdout = System.out;
    private final static ByteArrayOutputStream captor = new ByteArrayOutputStream();

    @BeforeAll
    public static void beforeAll() {
        System.setOut(new PrintStream(captor));
    }

    @AfterAll
    public static void afterAll() {
        System.setOut(stdout);
    }

    @Test
    void play_게임_실행_테스트() {

        InputView inputView = Mockito.mock(InputView.class);
        given(inputView.getCars()).willReturn(List.of(new Car("foo"), new Car("bar")));
        given(inputView.getAttempt()).willReturn(new Attempt(1));

        MockedStatic<RandomNumber> randomNumber = mockStatic(RandomNumber.class);
        given(RandomNumber.createRandomNumber()).willReturn(new RandomNumber(4));

        GameController gameController = new GameController(inputView, new OutputView());
        gameController.play();

        String output = captor.toString().trim();
        Assertions.assertThat(output).contains(
                "실행 결과", "foo : -", "bar : -", "최종 우승자 : foo, bar"
        );

        randomNumber.close();

    }

}