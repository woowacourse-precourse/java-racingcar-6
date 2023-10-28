package racingcar.dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateRacingCarRequest {

    private final List<String> racingCarNames = new ArrayList<>();

    public CreateRacingCarRequest(String names) {
        racingCarNames.addAll(Arrays.asList(names.split(",")));
    }

    public List<String> getRacingCarNames() {
        return racingCarNames;
    }

}
