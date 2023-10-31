package racingcar.model;

import static racingcar.constant.ErrorMessage.EMPTY_PROGRESS_RESPONSES_MSG;
import static racingcar.constant.ErrorMessage.EMPTY_WINNERS_MSG;

import java.util.List;
import java.util.Objects;
import racingcar.model.dto.CarProgressResponse;

public record GameResult(List<CarProgressResponse> progressResponses, List<String> winners) {

    public GameResult {
        if(progressResponses == null || progressResponses.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_PROGRESS_RESPONSES_MSG.getMessage());
        }

        if(winners == null || winners.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_WINNERS_MSG.getMessage());
        }
    }
}
