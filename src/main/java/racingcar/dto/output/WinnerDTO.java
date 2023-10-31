package racingcar.dto.output;

import java.util.List;

public final class WinnerDTO {
    private final List<String> names;

    private WinnerDTO(List<String> names) {
        this.names = names;
    }

    public static WinnerDTO of(List<String> winnerNames) {
        return new WinnerDTO(winnerNames);
    }

    @Override
    public String toString() {
        return "최종 우승자 : " + String.join(",", names);
    }
}
