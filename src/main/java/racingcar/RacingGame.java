package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private Track track;

    public RacingGame() {
        ready();
    }

    public void race() {
        track.race();
    }

    private void ready() {
        List<String> carNames = acceptApplicants();
        int raceCount = assignRaceCount();

        List<RacingCar> racingCars = createRacingCars(carNames);
        track = new Track(raceCount, racingCars);
    }

    public List<RacingCar> createRacingCars(List<String> carNames) {
        List<RacingCar> applicants = new ArrayList<>();
        carNames.forEach((name) -> {
            applicants.add(new RacingCar(name));
        });
        return applicants;
    }

    public int assignRaceCount() {
        return 4;
    }

    private List<String> acceptApplicants() {
        String carNames = "";
        return List.of(carNames.split(","));
    }
}
