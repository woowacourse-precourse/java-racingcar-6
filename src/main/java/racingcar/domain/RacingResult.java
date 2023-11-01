package racingcar.domain;

import java.util.List;
import racingcar.dto.CarStatusDto;

public class RacingResult {
    private static final String SCORE_FORMAT = "-";
    
    private final List<CarStatusDto> carStatusDto;

    private RacingResult(List<CarStatusDto> playerStatusDto) {
        this.carStatusDto = playerStatusDto;
    }

    public static RacingResult create(List<CarStatusDto> playerStatusDto) {
        return new RacingResult(playerStatusDto);
    }

    public List<String> referExecution() {
        return carStatusDto.stream()
                .map(this::executionResult)
                .toList();
    }

    public List<String> referWinner() {
        int highestScore = highestScore();
        return carStatusDto.stream()
                .filter(player -> player.score() == highestScore)
                .map(CarStatusDto::name)
                .toList();
    }

    private String executionResult(CarStatusDto dto) {
        return String.format("%s : %s\n",
                dto.name(),
                SCORE_FORMAT.repeat(dto.score()));
    }

    private int highestScore() {
        return carStatusDto.stream()
                .mapToInt(CarStatusDto::score)
                .max()
                .getAsInt();
    }
}
