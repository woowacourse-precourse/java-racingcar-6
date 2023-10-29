package racingcar.view.constant;

import java.util.List;
import racingcar.dto.MoveResultDto;

public class Result implements Message {

    private final String message;

    public Result(List<MoveResultDto> moveResultDtos) {
        message = moveResultDtos.stream()
                .map(this::createResult)
                .toString();
    }

    private String createResult(MoveResultDto moveResultDto) {
        String location = "-".repeat(moveResultDto.getLocation());
        return moveResultDto.getName() + " : " + location + "\n";
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
