package racingcar.dto;

import java.util.List;

public class RaceResultResponse {
    private List<String> cars;
    private List<Integer> raceResult;

    public RaceResultResponse(List<String> cars, List<Integer> raceResult) {
        this.cars = cars;
        this.raceResult = raceResult;
    }

    public List<String> getCars() {
        return cars;
    }
    public List<Integer> getRaceResult() {
        return raceResult;
    }
}
