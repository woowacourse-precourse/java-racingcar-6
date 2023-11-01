package racingcar;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import racingcar.domain.Distance;
import racingcar.domain.NumberGenerator;
import racingcar.domain.Player;
import racingcar.domain.PlayerMove;
import racingcar.domain.RandomNumberGenerator;
import racingcar.dto.MoveResultDto;

public class MoveResultDtoTest {
    NumberGenerator numberGenerator = new RandomNumberGenerator();

    @Test
    void from은_플레이어의_이동현황을_받아_결과DTO로_반환한다() {
        PlayerMove playerMove = PlayerMove.from(Player.from("test"), Distance.from(1));

        MoveResultDto moveResultDto = MoveResultDto.from(playerMove);

        assertEquals("test", moveResultDto.getPlayerName());
        assertEquals(1, moveResultDto.getDistance());
    }
}
