package racingcar.view;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import racingcar.io.InputSource;

class InputViewTest {

    private InputSource inputSource;
    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputSource = Mockito.mock(InputSource.class);
        inputView = new InputView(inputSource);
    }

    @Test
    void inputCarNames_자동차_이름_반환_테스트() {
        when(inputSource.readInput()).thenReturn("pobi,jun,woni");
        List<String> carNames = inputView.inputCarNames();
        assertThat(carNames).containsExactly("pobi", "jun", "woni");
    }

    @Test
    void inputAttemptCount_시도횟수_반환_테스트() {
        when(inputSource.readInput()).thenReturn("5");
        int attemptCount = inputView.inputAttemptCount();
        assertThat(attemptCount).isEqualTo(5);
    }

}