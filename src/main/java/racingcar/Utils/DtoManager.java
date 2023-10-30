package racingcar.Utils;

import java.util.List;
import racingcar.Dto.RacingCarDto;

public class DtoManager {
    private final RacingCarDto racingCarDto = new RacingCarDto();

    public RacingCarDto getRacingCarDto() {
        return racingCarDto;
    }

    public void setRacingCarDto(List<String> inputCarNames) {
        racingCarDto.setCarNames(inputCarNames);
    }
}
