package racingcar.dto;

import java.util.Map;

public record CarNamesWithDistanceDto(Map<String, Integer> carNamesWithDistance) {
    public static CarNamesWithDistanceDto from(Map<String, Integer> carNamesWithDistance) {
        return new CarNamesWithDistanceDto(carNamesWithDistance);
    }
}