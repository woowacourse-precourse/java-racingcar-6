package racingcar.dto;

import java.util.List;

public record RoundResponses(
        List<RoundResponse> roundsResponse
) {
    public List<String> toResponseList() {
        return roundsResponse.stream()
                .map(RoundResponse::toResponse)
                .toList();
    }
}
