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
import racingcar.dto.MoveResultDto;

public class MoveResultDtoTest {
    NumberGenerator numberGenerator = new RandomNumberGenerator();
    MoveFactory moveFactory = new MoveFactory(numberGenerator);

    @Test
    void from은_플레이어의_이동현황을_받아_결과DTO로_반환한다() {
        // 리팩토링 필요@
        // given
        List<PlayerMove> playerMoves = List.of(PlayerMove.fromTest(), PlayerMove.fromTest());
        PlayerMoveList playerMoveList = PlayerMoveList.of(playerMoves, moveFactory);
        List<MoveResultDto> moveResultDtoList = new ArrayList<>();
        for (PlayerMove playerMove : playerMoveList.getPlayerMoveList()) {
            // when
            MoveResultDto moveResultDto = MoveResultDto.from(playerMove);
            moveResultDtoList.add(moveResultDto);
            // then
            assertEquals("test", moveResultDto.getPlayerName());
            assertEquals(0, moveResultDto.getDistance());
        }
    }
}
