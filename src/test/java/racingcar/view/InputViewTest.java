package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.dto.CarRequestDto;
import racingcar.model.dto.GameRequestDto;

class InputViewTest {
    private InputStream inputStream;

    @Test
    @DisplayName("'경주할 자동차 이름을 입력하세요.' 출력 및, 자동차 이름을 입력을 테스트 합니다.")
    void 게임_시작_문구_출력_및_자동차_이름_입력() {
        String carName = "pobi,woni,jun";

        try {
            inputStream = new ByteArrayInputStream(carName.getBytes());
            System.setIn(inputStream);

            CarRequestDto carRequestDto = InputView.setCarNames();

            assertThat(carRequestDto.getNames()).isEqualTo(new CarRequestDto(carName).getNames());
        } catch (Exception ignored) {
        }
    }

    @Test
    @DisplayName("'시도할 회수는 몇회인가요?' 출력 및, 시도 횟수 입력을 테스트 합니다.")
    void 게임_시도_횟수_문구_출력_및_시도_횟수_입력() {
        String trial = "5";

        try {
            inputStream = new ByteArrayInputStream(trial.getBytes());
            System.setIn(inputStream);

            GameRequestDto gameRequestDto = InputView.setGameTrial();

            assertThat(gameRequestDto.getTrial()).isEqualTo(Integer.parseInt(trial));
        } catch (Exception ignored) {
        }
    }
}