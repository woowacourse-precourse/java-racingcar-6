package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputControllerTest {
    private InputController inputController;

    @BeforeEach
    void setUp() {
        inputController = new InputController();
    }

    @Test
    @DisplayName("입력받은 이름으로 자동차를 생성하는 기능")
    void setCar_입력받은_이름으로_자동차를_생성하는_기능() {
        String input = "pobi,woni,jun";

        List<Car> carList = inputController.setCar(input);

        assertThat(carList)
                .extracting(Car::getName)
                .containsExactly("pobi", "woni", "jun");
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobiwoni,jun", "pobiwonijun", "pobibi,woni,jun"})
    @DisplayName("입력받은 이름양식이 잘못된 경우 예외처리")
    void setCar_입력받은_이름양식이_잘못된_경우_예외처리(String carNames) {

        assertThatThrownBy(() -> inputController.setCar(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자이하이고 여러개라면 쉽표(,)로 구분해야 합니다.");
    }
}