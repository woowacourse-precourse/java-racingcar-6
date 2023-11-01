package racingcar.dto;

import java.util.List;
import java.util.Objects;

public class PlayResultDTO {
    private final List<ResultEachTry> playResults;

    public PlayResultDTO(List<ResultEachTry> playResults) {
        this.playResults = playResults;
    }

    public List<ResultEachTry> getPlayResults() {
        return playResults;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PlayResultDTO that = (PlayResultDTO) o;
        return Objects.equals(playResults, that.playResults);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playResults);
    }
}