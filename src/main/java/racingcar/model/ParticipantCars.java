package racingcar.model;

import java.util.List;
import racingcar.model.Car;

public class ParticipantCars {

    private final List<Car> participantCars;

    public ParticipantCars(List<Car> participantCars) {
        this.participantCars = participantCars;
    }

    public List<Car> getParticipantCars() {
        return participantCars;
    }
}