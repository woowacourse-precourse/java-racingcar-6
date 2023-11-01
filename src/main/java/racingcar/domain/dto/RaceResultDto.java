package racingcar.domain.dto;

import java.util.List;

public class RaceResultDto {
    
    private final List<CarStatusDto> carStatusDtos;

    private RaceResultDto(final List<CarStatusDto> carStatusDtos) {
        this.carStatusDtos = carStatusDtos;
    }

    public static RaceResultDto create(final List<CarStatusDto> carStatusDtos) {
        return new RaceResultDto(carStatusDtos);
    }

    public List<CarStatusDto> getCarRaceResults() {
        return carStatusDtos;
    }
}
