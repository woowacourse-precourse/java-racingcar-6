package racingcar.view;

import java.util.Arrays;
import java.util.List;
import racingcar.view.dto.RacingCarUserInputDto;

public class RacingCarViewerMapper {
    public Integer toInteger(String s) {
        return Integer.parseInt(s);
    }

    public RacingCarUserInputDto toRacingCarUserInputDto(List<String> carNames, int numberOfAttempts) {
        return new RacingCarUserInputDto(carNames, numberOfAttempts);
    }

    public List<String> toCarNames(String separator, String carNames) {
        return Arrays.stream(carNames.split(separator))
                .toList();
    }
}
