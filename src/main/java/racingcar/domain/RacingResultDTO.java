package racingcar.domain;

import java.util.List;

public record RacingResultDTO(List<String> names, List<Integer> positions) {
}