package racingcar.view;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {
    private InputStream inputStream;

    @Test
    @DisplayName("경주할 자동차 이름을 입력하세요. 출력 후, 자동차 이름을 입력합니다.")
    void 게임_시작_문구_출력_및_자동차_이름_입력() {
        String carName = "pobi,woni,jun";

        try {
            inputStream = new ByteArrayInputStream(carName.getBytes());
            System.setIn(inputStream);

            String actualInput = InputView.setCarNames();

            assertThat(actualInput).isEqualTo(carName);
        } catch (Exception ignored) {
        }
    }
}