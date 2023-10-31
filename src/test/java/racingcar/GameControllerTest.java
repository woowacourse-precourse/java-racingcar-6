package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.controller.GameController;
import racingcar.util.NumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;


class GameControllerTest {

    @DisplayName("성공적으로 playGame 메서드가 실행됨")
    @Test
    void testPlayGame() {
        // Mock 객체 생성
        InputView inputView = mock(InputView.class);
        OutputView outputView = mock(OutputView.class);
        NumberGenerator numberGenerator = mock(NumberGenerator.class);

        GameController gameController = new GameController(inputView, outputView, numberGenerator);

        // 테스트를 위한 입력 및 기대 결과 설정
        when(inputView.inputCars()).thenReturn("car1,car2,car3");
        when(inputView.inputTryCount()).thenReturn("5");

        // playGame 메서드 실행
        gameController.playGame();

        // playGame 메서드 내에서 호출되는 메서드들의 호출 여부를 확인
        verify(outputView).requestCarNames();
        verify(outputView).requestTryCount();
        verify(outputView).printStartResult();
        verify(outputView, atLeast(1)).printRacingStatus(anyMap());
        verify(outputView).printResult(anyString());
    }
    @Test
    @DisplayName("TryCount값에 잘못된 값이 들어옴")
    void testPlayGameWithInvalidTryCount() {
        // Mock 객체 생성
        InputView inputView = mock(InputView.class);
        OutputView outputView = mock(OutputView.class);
        NumberGenerator numberGenerator = mock(NumberGenerator.class);

        // GameController 객체 생성 및 의존성 주입
        GameController gameController = new GameController(inputView, outputView, numberGenerator);

        // 테스트를 위한 입력 및 기대 결과 설정
        when(inputView.inputCars()).thenReturn("car1,car2,car3");
        when(inputView.inputTryCount()).thenReturn("invalid"); // 유효하지 않은 값

        // playGame 메서드 실행
        // 유효하지 않은 tryCount 값으로 인해 예외가 발생해야 함
        assertThatThrownBy(gameController::playGame)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
