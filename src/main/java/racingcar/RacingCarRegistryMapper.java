package racingcar;

import java.util.List;
import racingcar.dto.CreateRacingCarRequest;
import racingcar.dto.MoveCountDto;

public class RacingCarRegistryMapper {

    public static RacingCarRegistry toRacingCarRegistry(
            ActionNumberGenerator actionNumberGenerator,
            CreateRacingCarRequest createRacingCarRequest,
            MoveCountDto moveCountDto) {
        MoveCount moveCount = new MoveCount(moveCountDto.getMoveCount());
        List<String> racingCarNames = createRacingCarRequest.getRacingCarNames();
        return new RacingCarRegistry(actionNumberGenerator, racingCarNames, moveCount);
    }
}
