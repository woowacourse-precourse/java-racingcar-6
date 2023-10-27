package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mockStatic;

class GameBoardTest {
    private GameBoard gameBoard;

    @Test
    @DisplayName("턴 진행 후에 모든 플레이어의 위치가 1 증가한다.")
    void processTurn() {
        //given
        List<Player> players = List.of(Player.of("이요환"),
                Player.of("김동식"),
                Player.of("김동찬"));
        gameBoard = new GameBoard(players);

        try (MockedStatic<Randoms> randoms = mockStatic(Randoms.class)) {
            given(Randoms.pickNumberInRange(0, 9)).willReturn(5);

            //when
            gameBoard.processTurn();
            List<Player> result = gameBoard.getCopyOfPlayerList();

            //then
            assertThat(result)
                    .contains(Player.of("이요환", 1),
                            Player.of("김동찬", 1),
                            Player.of("김동식", 1));
        }
    }

    @Test
    @DisplayName("가장 많이 이동한 사람의 이름을 모두 반환한다.")
    void findWinnersTest() {
        //given
        List<Player> players = List.of(Player.of("이요환", 1),
                Player.of("김동식", 0),
                Player.of("김동찬", 1));
        gameBoard = new GameBoard(players);

        //when
        List<Player> result = gameBoard.findWinners();

        //then
        assertThat(result)
                .contains(Player.of("이요환", 1), Player.of("김동찬", 1))
                .doesNotContain(Player.of("김동식", 0));
    }
}