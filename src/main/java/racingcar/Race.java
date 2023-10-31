package racingcar;

import java.util.ArrayList;
import java.util.List;
import racingcar.validation.ParticipatingCarsValidation;

public class Race {
    private List<Car> participatingCars;
    private int moveCounts;
    public ParticipatingCarsValidation participatingCarsValidation;

    public Race() {
        participatingCars = new ArrayList<>();
        participatingCarsValidation = new ParticipatingCarsValidation();
    }

    public void registerCar(List<String> participatingCars) {
        participatingCarsValidation.validateParticipatingCars(participatingCars);
        for (String carName : participatingCars) {
            this.participatingCars.add(new Car(carName));
        }
    }
}