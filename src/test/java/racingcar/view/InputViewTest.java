package racingcar.view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest extends IOTest {

    private final InputView inputView = new InputView();

    @DisplayName("자동자 이름 입력 요청 메세지 출력 테스트")
    @Test
    void printRequestCarName() {
        String requestCarNameMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)\n";

        inputView.printRequestCarName();
        assertThat(getOutput()).isEqualTo(requestCarNameMessage);
    }

    @DisplayName("전진 시도 횟수 메시지 출력 테스트")
    @Test
    void printRequestRound() {
        String requestRacingRoundMessage = "시도할 회수는 몇회인가요?\n";

        inputView.printRequestRound();
        assertThat(getOutput()).isEqualTo(requestRacingRoundMessage);
    }

    @DisplayName("경기 횟수 입력 정상 반환 테스트")
    @Test
    void getUserInputRacingRound() {
        int testRacingRound = 4;
        String inputRacingRound = "4";
        int racingRound = inputView.getUserInputRacingRound(inputRacingRound);

        assertThat(testRacingRound).isEqualTo(racingRound);
    }
}