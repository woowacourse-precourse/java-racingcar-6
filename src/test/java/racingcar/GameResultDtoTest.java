package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

public class GameResultDtoTest {
    NumberGenerator numberGenerator = new RandomNumberGenerator();
    MoveFactory moveFactory = new MoveFactory(numberGenerator);

    @Test
    void from은_플레이어의_이동현황을_받아_결과DTO로_반환한다() {
        // given
        List<PlayerMove> playerMoves = List.of(PlayerMove.fromTest(), PlayerMove.fromTest());
        PlayerMoveList playerMoveList = PlayerMoveList.of(playerMoves, moveFactory);
        List<GameResultDto> gameResultDtoList = new ArrayList<>();
        for (PlayerMove playerMove : playerMoveList.getPlayerMoveList()) {
            // when
            GameResultDto gameResultDto = GameResultDto.from(playerMove);
            gameResultDtoList.add(gameResultDto);
            // then
            assertEquals("test", gameResultDto.getPlayerName());
            assertEquals(0, gameResultDto.getDistance());
        }

    }
}
