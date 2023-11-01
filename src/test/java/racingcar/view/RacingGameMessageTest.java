package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.utils.RacingGameMessage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingGameMessageTest {

    @DisplayName("게임 시작시 출력되는 메세지에 대한 테스트")
    @Test
    void getStartMessage() {
        //given
        String startMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

        //then
        assertThat(RacingGameMessage.START_MESSAGE.getMessage()).isEqualTo(startMessage);
    }

    @DisplayName("게임 시도 횟수를 요청하는 메시지에 대한 테스트")
    @Test
    void getRequestTryMessage() {
        //given
        String requestTryMessage = "시도할 회수는 몇회인가요?";

        //then
        assertThat(RacingGameMessage.REQUEST_RACE_COUNT_MESSAGE.getMessage()).isEqualTo(requestTryMessage);
    }

    @DisplayName("게임 실행 결과 메시지에 대한 테스트")
    @Test
    void getGameResultMessage() {
        //given
        String gameResultMessage = "실행 결과";

        //then
        assertThat(RacingGameMessage.GAME_RESULT_MESSAGE. getMessage())
                .isEqualTo(gameResultMessage);
    }

    @DisplayName("게임 최종 우승자 메시지에 대한 테스트")
    @Test
    void getWinnerMessage() {
        //given
        String winnerMessage = "최종 우승자 : ";
        String winner = "suhwpark";

        //then
        assertThat(RacingGameMessage.WINNER_MESSAGE.getWinnersMessage(winner)).isEqualTo(winnerMessage + winner);
    }
}