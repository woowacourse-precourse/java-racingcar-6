package racingcar.view.constant;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.MoveResultDto;

public class Result implements Message {

    private static final String MOVE_SYMBOL = "-";
    private static final String COLON = " : ";
    private static final String NEW_LINE = "\n";

    private final String result;

    private Result(List<MoveResultDto> moveResultDtos) {
        result = moveResultDtos.stream()
                .map(this::createResult)
                .collect(Collectors.joining());
    }

    public static Result announcement(List<MoveResultDto> moveResultDtos) {
        return new Result(moveResultDtos);
    }

    private String createResult(MoveResultDto moveResultDto) {
        String location = MOVE_SYMBOL.repeat(moveResultDto.getLocation());
        return moveResultDto.getName() + COLON + location + NEW_LINE;
    }

    @Override
    public String getMessage() {
        return result;
    }
}
