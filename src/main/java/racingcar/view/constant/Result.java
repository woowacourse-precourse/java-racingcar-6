package racingcar.view.constant;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.MoveResultDto;

public class Result implements Message {

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
        String location = "-".repeat(moveResultDto.getLocation());
        return moveResultDto.getName() + " : " + location + "\n";
    }

    @Override
    public String getMessage() {
        return result;
    }
}
