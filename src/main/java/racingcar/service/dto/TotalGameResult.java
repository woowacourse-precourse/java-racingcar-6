package racingcar.service.dto;

import java.util.List;

public record TotalGameResult(
        List<GameResult> results,
        List<String> winners
) {
}
