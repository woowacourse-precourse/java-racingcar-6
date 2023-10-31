package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.domain.MoveFactory;
import racingcar.domain.NumberGenerator;
import racingcar.domain.PlayerMove;
import racingcar.domain.PlayerMoveList;
import racingcar.domain.RandomNumberGenerator;
import racingcar.dto.PlayerMoveResultDto;

public class PlayerMoveResultDtoTest {
    NumberGenerator numberGenerator = new RandomNumberGenerator();
    MoveFactory moveFactory = new MoveFactory(numberGenerator);

    @Test
    void from은_플레이어의_이동현황을_받아_결과DTO로_반환한다() {
        // 리팩토링 필요@
        // given
        List<PlayerMove> playerMoves = List.of(PlayerMove.fromTest(), PlayerMove.fromTest());
        PlayerMoveList playerMoveList = PlayerMoveList.of(playerMoves, moveFactory);
        List<PlayerMoveResultDto> playerMoveResultDtoList = new ArrayList<>();
        for (PlayerMove playerMove : playerMoveList.getPlayerMoveList()) {
            // when
            PlayerMoveResultDto playerMoveResultDto = PlayerMoveResultDto.from(playerMove);
            playerMoveResultDtoList.add(playerMoveResultDto);
            // then
            assertEquals("test", playerMoveResultDto.getPlayerName());
            assertEquals(0, playerMoveResultDto.getDistance());
        }
    }
}
