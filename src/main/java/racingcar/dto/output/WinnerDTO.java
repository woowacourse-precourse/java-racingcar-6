package racingcar.dto.output;

import java.util.List;

public final class WinnerDTO {
    private final List<String> names;

    public static WinnerDTO of(List<String> winnerNames) {
        return new WinnerDTO(winnerNames);
    }

    private WinnerDTO(List<String> names) {
        this.names = names;
    }

    @Override
    public String toString() {
        return "최종 우승자 : " + String.join(",", names);
    }
}
