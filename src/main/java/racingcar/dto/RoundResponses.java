package racingcar.dto;

import java.util.List;

public record RoundResponses(
        List<RoundResponse> roundsResponse
) {
    public List<String> toEntityList() {
        return roundsResponse.stream()
                .map(RoundResponse::toEntity)
                .toList();
    }
}
