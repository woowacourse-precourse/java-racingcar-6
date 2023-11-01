package racingcar.view;

import static racingcar.constant.RacingSign.CAR_NAME_SEPARATOR;

import java.util.List;
import racingcar.dto.request.CarNames;
import racingcar.dto.request.TryCount;

public class InputMapper {

    public CarNames toCarNames(String input) {
        return CarNames.from(List.of(input.split(CAR_NAME_SEPARATOR.toString())));
    }

    public TryCount toTryCount(String input) {
        return TryCount.fromInput(input);
    }
}
