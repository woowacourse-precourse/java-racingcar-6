package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingCars {
    private final List<RacingCar> racingCars = new ArrayList<>();

    public RacingCars(String nameInput) {
        String[] carNames = nameInput.split(",", -1);

        for (String carName : carNames) {
            racingCars.add(new RacingCar(carName));
        }
    }

    public List<RacingCar> getRacingCars() {
        return Collections.unmodifiableList(racingCars);
    }

    public List<String> getWinners() {
        int maxDistance = 0;
        List<String> winners = new ArrayList<>();

        for (RacingCar racingCar : racingCars) {
            String name = racingCar.getName();
            int distance = racingCar.getDistance();

            if (distance == maxDistance) {
                winners.add(name);
            }
            if (distance > maxDistance) {
                winners.clear();
                winners.add(name);
                maxDistance = distance;
            }
        }

        return winners;
    }
}
