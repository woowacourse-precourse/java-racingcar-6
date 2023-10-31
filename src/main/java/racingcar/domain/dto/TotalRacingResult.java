package racingcar.domain.dto;

import java.util.List;

public class TotalRacingResult {
    private final List<CarsStatus> TotalCarsStatus;
    private final String winners;

    public TotalRacingResult(List<CarsStatus> totalCarsStatus, String winners) {
        this.TotalCarsStatus = totalCarsStatus;
        this.winners = winners;
    }

    public static TotalRacingResult of(List<CarsStatus> totalCarsStatus, String winners) {
        return new TotalRacingResult(totalCarsStatus, winners);
    }

    public List<CarsStatus> getTotalCarsStatus() {
        return TotalCarsStatus;
    }

    public String getWinners() {
        return winners;
    }
}
