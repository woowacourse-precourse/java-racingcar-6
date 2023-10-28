package racingcar.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.RacingCarRegistry;

public class RacingCarNameRegistryDto {

    private final List<String> racingCarNames = new ArrayList<>();

    public RacingCarNameRegistryDto(String names) {
        racingCarNames.addAll(Arrays.asList(names.split(",")));
    }

    public List<String> getRacingCarNames() {
        return racingCarNames;
    }

    public RacingCarRegistry toRacingCarRegistry() {
        return new RacingCarRegistry(racingCarNames);
    }
}
