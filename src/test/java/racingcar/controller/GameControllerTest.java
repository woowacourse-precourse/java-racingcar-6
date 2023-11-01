package racingcar.controller;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import racingcar.Application;
import racingcar.domain.Attempt;
import racingcar.domain.Car;
import racingcar.domain.RandomNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

class GameControllerTest extends NsTest {

    @Test
    void play_게임_실행_테스트() {

        InputView inputView = Mockito.mock(InputView.class);
        given(inputView.getCars()).willReturn(List.of(new Car("foo"), new Car("bar")));
        given(inputView.getAttempt()).willReturn(new Attempt(1));

        MockedStatic<RandomNumber> randomNumber = mockStatic(RandomNumber.class);
        given(RandomNumber.createRandomNumber()).willReturn(new RandomNumber(4));

        GameController gameController = new GameController(inputView, new OutputView());
        gameController.play();

        Assertions.assertThat(output()).contains(
                "실행 결과", "foo : -", "bar : -", "최종 우승자 : foo, bar"
        );

        randomNumber.close();

    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}