package racingcar.dto;

import java.util.List;

public class WinnerResponse {
    List<String> winner;

    public WinnerResponse(List<String> winner) {
        this.winner = winner;
    }

    public List<String> getWinner() {
        return winner;
    }
}
