package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.IOTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class InputViewTest extends IOTest {


    @DisplayName("플레이어가 자동차 이름 입력테스트")
    @Test
    void inputCarNameTest() {
        // given
        final InputView inputView = new InputView();
        final String playerInput = "우하하, 우히히, 헤헤";
        systemIn(playerInput);

        // when
        List<String> playerInputName = inputView.inputCarName();

        // then
        assertThat(playerInputName).as("사용자가 입력한 값이 제대로 분리되지 않았습니다.")
                .containsOnly("우하하", "우히히", "헤헤");
    }


}
