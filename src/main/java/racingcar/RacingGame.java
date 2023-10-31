package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    public RacingGame() {
        ready();
    }

    private void ready() {
        List<String> carNames = acceptApplicants();

        List<RacingCar> racingCars = createRacingCars(carNames);
    }

    public List<RacingCar> createRacingCars(List<String> carNames) {
        List<RacingCar> applicants = new ArrayList<>();
        carNames.forEach((name) -> {
            applicants.add(new RacingCar(name));
        });
        return applicants;
    }

    private List<String> acceptApplicants() {
        String carNames = "";
        return List.of(carNames.split(","));
    }
}
