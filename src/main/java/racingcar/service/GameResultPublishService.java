package racingcar.service;

import java.util.List;
import racingcar.dto.CarStatusDto;
import racingcar.dto.GameResultDto;
import racingcar.dto.RoundResultDto;

public class GameResultPublishService {

    public GameResultDto publishGameResult(List<RoundResultDto> roundHistories, List<CarStatusDto> winners) {
        return GameResultDto.of(winners, roundHistories);
    }

}
