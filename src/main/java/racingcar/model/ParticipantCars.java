package racingcar;

import java.util.List;

public class ParticipantCars {

    private final List<Car> participantCars;

    public ParticipantCars(List<Car> participantCars) {
        this.participantCars = participantCars;
    }

    public List<Car> getParticipantCars() {
        return participantCars;
    }
}