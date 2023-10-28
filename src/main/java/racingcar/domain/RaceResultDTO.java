package racingcar.domain;

import java.util.List;
import java.util.Map;

public record RaceResultDTO(List<String> names, Map<String, Integer> positions) {
}
