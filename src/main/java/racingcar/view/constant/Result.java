package racingcar.view.constant;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.RaceResultDTO;

public class Result implements Message {

    private static final String MOVE_SYMBOL = "-";
    private static final String COLON = " : ";
    private static final String NEW_LINE = "\n";

    private final String result;

    private Result(List<RaceResultDTO> raceResultDTOS) {
        result = raceResultDTOS.stream()
                .map(this::createResult)
                .collect(Collectors.joining());
    }

    public static Result announcement(List<RaceResultDTO> raceResultDTOS) {
        return new Result(raceResultDTOS);
    }

    private String createResult(RaceResultDTO raceResultDTO) {
        String location = MOVE_SYMBOL.repeat(raceResultDTO.getLocation());
        return raceResultDTO.getName() + COLON + location + NEW_LINE;
    }

    @Override
    public String getMessage() {
        return result;
    }
}
