package racingcar.model;

import java.util.List;

public final class GameResult {
    private final List<CarProgressResponse> progressResponses;
    private final List<String> winners;

    public GameResult(List<CarProgressResponse> progressResponses, List<String> winners) {
        this.progressResponses = progressResponses;
        this.winners = winners;
    }

    public List<CarProgressResponse> getProgressResponses() {
        return progressResponses;
    }

    public List<String> getWinners() {
        return winners;
    }
}
