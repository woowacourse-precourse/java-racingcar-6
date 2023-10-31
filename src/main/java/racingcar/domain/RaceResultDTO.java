package racingcar.domain;

import java.util.List;

public record RaceResultDTO(List<String> names, List<Integer> positions) {
}