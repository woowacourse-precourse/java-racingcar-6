package racingcar.model;

import java.util.List;
import java.util.Objects;

public record GameResult(List<CarProgressResponse> progressResponses, List<String> winners) {

    public GameResult {
        Objects.requireNonNull(progressResponses, "게임 결과는 비어있을 수 없습니다.");

        if(progressResponses.size() < 1) {
            throw new IllegalArgumentException("프로그램 결과는 하나 이상이어야 합니다.");
        }
    }
}
