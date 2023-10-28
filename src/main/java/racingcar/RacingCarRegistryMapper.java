package racingcar;

import java.util.List;
import racingcar.dto.MoveCountDto;
import racingcar.dto.RacingCarNameRegistryDto;

public class RacingCarRegistryMapper {

    public static RacingCarRegistry toRacingCarRegistry(
            RacingCarNameRegistryDto racingCarNameRegistryDto,
            MoveCountDto moveCountDto) {
        MoveCount moveCount = new MoveCount(moveCountDto.getMoveCount());
        List<String> racingCarNames = racingCarNameRegistryDto.getRacingCarNames();
        return new RacingCarRegistry(racingCarNames, moveCount);
    }
}
