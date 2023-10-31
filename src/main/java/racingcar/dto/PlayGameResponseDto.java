package racingcar.dto;

import java.util.List;

public class PlayGameResponseDto {
    public PlayGameResponseDto(List<String> winnerList) {
        this.winnerList = winnerList;
    }

    private final List<String> winnerList;

    public List<String> getWinnerList() {
        return winnerList;
    }
}
