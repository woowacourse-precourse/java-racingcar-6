package racingcar.dto;

import java.util.List;
import java.util.Objects;

public class WinnersDTO {
    private List<String> winnerNames;

    public WinnersDTO(List<String> winnerNames) {
        this.winnerNames = winnerNames;
    }

    public List<String> getWinnerNames() {
        return winnerNames;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinnersDTO that = (WinnersDTO) o;
        return Objects.equals(winnerNames, that.winnerNames);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winnerNames);
    }
}
