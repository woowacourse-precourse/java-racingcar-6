package racingcar.dto;

import java.util.List;
import racingcar.domain.Racing;

public record WinnerDto(List<String> names) {

    public static WinnerDto from(Racing racing) {
        return new WinnerDto(racing.findWinnersName());
    }
}
