package racingcar.model;

import java.util.List;
import java.util.Objects;
import racingcar.model.dto.CarProgressResponse;

public record GameResult(List<CarProgressResponse> progressResponses, List<String> winners) {

    public GameResult {
        if(progressResponses == null || progressResponses.isEmpty()) {
            throw new IllegalArgumentException("게임 결과는 하나 이상 이어야 합니다.");
        }

        if(winners == null || winners.isEmpty()) {
            throw new IllegalArgumentException("우승자는 한명 이상 이어야 합니다.");
        }
    }
}
