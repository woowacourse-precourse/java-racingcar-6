package racingcar.dto;

import java.util.List;

public class RacingResultDto {

    private List<RacingCarDto> racingCarDtos;

    public RacingResultDto(List<RacingCarDto> racingCarDtos) {
        this.racingCarDtos = racingCarDtos;
    }

    public List<RacingCarDto> getRacingCarDtos() {
        return racingCarDtos;
    }
}
