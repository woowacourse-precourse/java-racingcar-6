package racingcar.dto.output;

import java.util.List;

public record WinnerInfo(List<String>names) {
    @Override
    public String toString() {
        return "최종 우승자 : " + String.join(",", names);
    }
}
