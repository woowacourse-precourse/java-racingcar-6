package racingcar.view.dto;

import java.util.List;

public record RacingCarUserInputDto(List<String> carNames, int numberOfAttempts) {
}
