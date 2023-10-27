package racingcar.view;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class GameMessageTest {

    @Test
    void getStartMessage() {
        //given
        String startMessage = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
        //then
        assertThat(GameMessage.START_MESSAGE.getStartMessage()).isEqualTo(startMessage);
    }

    @Test
    void getRequestTryMessage() {
        //given
        String requestTryMessage = "시도할 회수는 몇회인가요?";
        //then
        assertThat(GameMessage.REQUEST_TRY_MESSAGE.getRequestTryMessage()).isEqualTo(requestTryMessage);
    }

    @Test
    void getGameResultMessage() {
        //given
        String gameResultMessage = "실행 결과";
        //then
        assertThat(GameMessage.GAME_RESULT_MESSAGE.getGameResultMessage()).isEqualTo(gameResultMessage);
    }

    @Test
    void getWinnerMessage() {
        //given
        String winnerMessage = "최종 우승자 : ";
        //then
        assertThat(GameMessage.WINNER_MESSAGE.getWinnerMessage()).isEqualTo(winnerMessage);
    }
}