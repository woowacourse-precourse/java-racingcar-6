package racingcar.dto.response;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.CarGroup;
import racingcar.model.RaceHistory;

public class RaceHistoryDto {
    private final List<RaceStageDto> raceStages;

    private RaceHistoryDto(List<RaceStageDto> raceStages) {
        this.raceStages = raceStages;
    }

    public static RaceHistoryDto from(RaceHistory raceHistory) {
        List<CarGroup> raceStages = raceHistory.getRaceStages();
        List<RaceStageDto> raceStageDtoList = getRaceStageDtoList(raceStages);
        return new RaceHistoryDto(raceStageDtoList);
    }

    private static List<RaceStageDto> getRaceStageDtoList(List<CarGroup> raceStages) {
        return raceStages.stream()
                .map(RaceStageDto::from)
                .collect(Collectors.toList());
    }

    public List<RaceStageDto> getRaceStages() {
        return raceStages;
    }
}
