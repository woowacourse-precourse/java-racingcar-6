package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.dto.CarRequestDto;
import racingcar.model.dto.GameRequestDto;

class InputViewTest {
    private final String carNames = "pobi,woni,jun";
    private final String trial = "5";
    private InputStream inputStream;

    @Test
    @DisplayName("'경주할 자동차 이름을 입력하세요.' 출력 및, 자동차 이름을 입력을 테스트 합니다.")
    void 게임_시작_문구_출력_및_자동차_이름_입력() {
        try {
            inputStream = new ByteArrayInputStream(carNames.getBytes());
            System.setIn(inputStream);

            CarRequestDto carRequestDto = InputView.getCarNames();

            assertThat(carRequestDto.getCarNames()).isEqualTo(new CarRequestDto(carNames).getCarNames());
        } catch (Exception e) {
            e.getMessage();
        }
    }

    @Test
    @DisplayName("'시도할 회수는 몇회인가요?' 출력 및, 시도 횟수 입력을 테스트 합니다.")
    void 게임_시도_횟수_문구_출력_및_시도_횟수_입력() {
        try {
            inputStream = new ByteArrayInputStream(trial.getBytes());
            System.setIn(inputStream);

            GameRequestDto gameRequestDto = InputView.getGameTrial();

            assertThat(gameRequestDto.getTrial()).isEqualTo(5);
        } catch (Exception e) {
            e.getMessage();
        }
    }
}