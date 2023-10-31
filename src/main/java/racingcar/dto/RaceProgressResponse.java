package racingcar.dto;

import java.util.List;

public class RaceProgressResponse {
    private List<String> cars;
    private List<Integer> raceProgress;

    public RaceProgressResponse(List<String> cars, List<Integer> raceProgress) {
        this.cars = cars;
        this.raceProgress = raceProgress;
    }

    public List<String> getCars() {
        return cars;
    }
    public List<Integer> getRaceProgress() {
        return raceProgress;
    }
}