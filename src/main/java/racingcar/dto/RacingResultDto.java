package racingcar.dto;


import java.util.List;
import java.util.stream.Collectors;

public record RacingResultDto(List<String> carNames) {

    public static RacingResultDto from(List<String> finalWinners) {
        return finalWinners.stream()
                .map(String::new)
                .collect(Collectors.collectingAndThen(Collectors.toUnmodifiableList(), RacingResultDto::new));
    }
}
