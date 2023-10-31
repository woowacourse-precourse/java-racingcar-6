package racingcar.domain.car.view;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import racingcar.domain.util.ErrorMessage;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
import static racingcar.domain.util.ErrorMessage.*;

class CarInputViewTest {


    private CarInputView carInputView;
    private MockedStatic<Console> consoleMockedStatic;

    @BeforeEach
    public void setUp() {
        carInputView = new CarInputView();
        consoleMockedStatic = mockStatic(Console.class);
    }

    @AfterEach
    public void clear() {
        consoleMockedStatic.close();
    }

    @Nested
    @DisplayName("자동차 이름 입력 테스트")
    class CarNameInputTest {

        @Test
        @DisplayName("자동차 입력을 성공적으로 받아야 한다")
        public void 자동차_입력을_성공적으로_받아야_한다() {
            when(Console.readLine()).thenReturn("pobi,jun,woni");

            List<String> carNames = carInputView.getCarNames();

            assertThat(carNames.size()).isEqualTo(3);
            assertThat(carNames.get(0)).isEqualTo("pobi");
            assertThat(carNames.get(1)).isEqualTo("jun");
            assertThat(carNames.get(2)).isEqualTo("woni");
        }
    }

    @Nested
    @DisplayName("자동차 이름 입력 예외 테스트")
    class CarNameExceptionTest {

        @Test
        @DisplayName("자동차 이름이 6자 이상일 경우 예외를 발생시켜야 한다")
        public void 자동차_이름이_6자_이상일_경우_예외를_발생시켜야_한다() {
            when(Console.readLine()).thenReturn("pooooooobi,juuuuuuuun,wooooooooni");

            // jupiter
            assertThrows(IllegalArgumentException.class,
                    carInputView::getCarNames,
                    CAR_NAME_LENGTH_OVER.getErrorMessage());

            // assertJ.core
            assertThatThrownBy(() -> carInputView.getCarNames())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(CAR_NAME_LENGTH_OVER.getErrorMessage());
        }

        @Test
        @DisplayName("시도 횟수 입력이 숫자가 아닌 경우 예외를 발생시켜야 한다")
        public void 시도_횟수_입력이_숫자가_아닌_경우_예외를_발생시켜야_한다() {
            when(Console.readLine()).thenReturn("NotIntInput");

            // jupiter
            assertThrows(IllegalArgumentException.class,
                    carInputView::getTryCount,
                    TRY_COUNT_IS_NOT_DIGIT.getErrorMessage());

            // assertJ.core
            assertThatThrownBy(() -> carInputView.getTryCount())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(TRY_COUNT_IS_NOT_DIGIT.getErrorMessage());

        }

        @Test
        @DisplayName("시도 횟수 입력이 0인 경우 예외를 발생시켜야 한다")
        public void 시도_횟수_입력이_0인_경우_예외를_발생시켜야_한다() {
            when(Console.readLine()).thenReturn("0");

            // jupiter
            assertThrows(IllegalArgumentException.class,
                    carInputView::getTryCount,
                    TRY_COUNT_IS_ZERO.getErrorMessage());

            // assertJ.core
            assertThatThrownBy(() -> carInputView.getTryCount())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(TRY_COUNT_IS_ZERO.getErrorMessage());
        }

        @ParameterizedTest
        @ValueSource(strings = {"pobi,", "", "pobi,woni,"})
        @DisplayName("시도 횟수 입력이 0인 경우 예외를 발생시켜야 한다")
        public void 시도_횟수_입력이_0인_경우_예외를_발생시켜야_한다(String carName) {
            when(Console.readLine()).thenReturn(carName);

            // jupiter
            assertThrows(IllegalArgumentException.class,
                    carInputView::getCarNames,
                    CAR_NAME_IS_EMPTY.getErrorMessage());

            // assertJ.core
            assertThatThrownBy(() -> carInputView.getCarNames())
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining(CAR_NAME_IS_EMPTY.getErrorMessage());
        }
    }

    @Nested
    @DisplayName("시도 횟수 입력 테스트")
    class TryCountInputViewTest {

        @Test
        @DisplayName("시도 횟수 입력을 성공적으로 받아야 한다")
        public void 시도_횟수_입력을_성공적으로_받아야_한다() {
            when(Console.readLine()).thenReturn("5");

            int tryCount = carInputView.getTryCount();

            assertThat(tryCount).isEqualTo(5);
        }
    }
}
