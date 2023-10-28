package racingcar.model.dto;

import java.util.List;

public record GameInput(List<String> carNames, Long totalTurns) {
}
