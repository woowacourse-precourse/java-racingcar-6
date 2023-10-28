package racingcar.model;

import java.util.List;
import java.util.Objects;
import racingcar.model.dto.CarProgressResponse;

public record GameResult(List<CarProgressResponse> progressResponses, List<String> winners) {

    public GameResult {
        Objects.requireNonNull(progressResponses, "게임 결과는 비어 있을 수 없습니다.");
        Objects.requireNonNull(progressResponses, "우승자는 비어 있을 수 없습니다.");

        if(progressResponses.isEmpty()) {
            throw new IllegalArgumentException("게임 결과는 하나 이상 이어야 합니다.");
        }

        if(winners.isEmpty()) {
            throw new IllegalArgumentException("우승자는 한명 이상 이어야 합니다.");
        }
    }
}
