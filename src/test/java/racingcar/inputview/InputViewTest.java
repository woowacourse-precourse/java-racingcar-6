package racingcar.inputview;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.CarList;
import racingcar.view.InputView;

public class InputViewTest {

    @ParameterizedTest
    @ValueSource(strings = "love, candy, happy")
    @DisplayName("InputView에서 자동차 이름을 정상적으로 입력받는다.")
    void inputView_addCarName_Test(String names) {
        Assertions.assertEquals(new CarList(names).getCarNames(), List.of("love", "candy", "happy"));
    }

    @ParameterizedTest
    @ValueSource(strings = "loveafdfdfgs")
    @DisplayName("InputView에서 ,를 안찍었을 경우 에플리케이션 종료")
    void inputView_addCarName_Exception_Test(String name) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new CarList(name));
        assertThat(e.getMessage()).isEqualTo("최소 두 개 이상의 차 이름을 입력해주세요.");
    }

    @ParameterizedTest
    @ValueSource(strings = "loveee, flowerrrr, happyyyy")
    @DisplayName("InputView에서 자동차 이름이 5글자 이상 일 경우 애플리케이션 종료.")
    void inputView_addCarNameLength_Test(String names) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> new CarList(names));
        assertThat(e.getMessage()).isEqualTo("차 이름은 다섯글자로 입력해주세요");
    }

    @Test
    @DisplayName("InputView에서 게임을 진행할 횟수를 정상적으로 입력받는다.")
    void inputView_runningGameNumber_Test() {
        String testInput = "1";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(inputStream);
        InputView inputView = new InputView();
        Assertions.assertEquals(inputView.gameRunningNumber(), Integer.valueOf(1));
    }

}
