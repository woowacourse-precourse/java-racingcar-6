package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import racingcar.domain.Distance;
import racingcar.domain.NumberGenerator;
import racingcar.domain.Player;
import racingcar.domain.PlayerMove;
import racingcar.domain.RandomNumberGenerator;
import racingcar.dto.PlayerMoveResultDto;

public class PlayerMoveResultDtoTest {
    NumberGenerator numberGenerator = new RandomNumberGenerator();

    @Test
    void from은_플레이어의_이동현황을_받아_결과DTO로_반환한다() {
        PlayerMove playerMove = PlayerMove.from(Player.from("test"), Distance.from(1));

        PlayerMoveResultDto playerMoveResultDto = PlayerMoveResultDto.from(playerMove);

        assertEquals("test", playerMoveResultDto.getPlayerName());
        assertEquals(1, playerMoveResultDto.getDistance());
    }
}
