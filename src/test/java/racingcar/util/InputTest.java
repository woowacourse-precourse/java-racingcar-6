package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import domain.Car;
import domain.Cars;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;

public class InputTest {
    @Test
    @DisplayName("아무것도 입력 안 한 경우 : 자동차가 0대인 경우")
    void no_enter_check() {
        Assertions.assertThatThrownBy(() -> new Cars(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력한 자동차가 2대 미만인 경우")
    void input_less_than_two_cars() {
        Assertions.assertThatThrownBy(() -> new Cars("ab"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("시도횟수 일치 확인")
    void attempt_count_match() {
        String simulatedInput = "5";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        int attempt = InputView.attemptCount();

        assertThat(attempt).isEqualTo(Integer.parseInt(simulatedInput));
    }

    @Test
    @DisplayName("입력 이름 분리 성공")
    void split_input_name_success() {
        Cars cars = new Cars("a,b,c");
        List<String> carNames = cars.getCarsList()
                .stream()
                .map(Car::getCarName)
                .toList();

        assertThat(carNames).containsOnly("a", "b", "c");
    }
}
