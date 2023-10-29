package racingcar.domain.car.view;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
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

    @Nested
    @DisplayName("자동차 이름 입력 테스트")
    class CarNameInputTest {

        @Test
        @DisplayName("자동차 입력을 성공적으로 받아야 한다")
        public void 자동차_입력을_성공적으로_받아야_한다() {
            CarInputView carInputView = new CarInputView();
            MockedStatic<Console> consoleMockedStatic = mockStatic(Console.class);
            when(Console.readLine()).thenReturn("pobi,jun,woni");

            List<String> carNames = carInputView.getCarNames();

            assertThat(carNames.size()).isEqualTo(3);
            assertThat(carNames.get(0)).isEqualTo("pobi");
            assertThat(carNames.get(1)).isEqualTo("jun");
            assertThat(carNames.get(2)).isEqualTo("woni");

            consoleMockedStatic.close();
        }
    }

}
