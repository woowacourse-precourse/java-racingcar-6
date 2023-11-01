package racingcar.dto;

import java.util.List;

public record RoundResponses(
        List<RoundResponse> roundsResponse
) {
    public List<String> getResponses() {
        return roundsResponse.stream()
                .map(RoundResponse::getResponse)
                .toList();
    }
}
