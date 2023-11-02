package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

public class Participants {
    private final List<Car> participants;

    public Participants(List<Car> cars) {
        this.participants = cars;
    }

    public List<Car> getParticipants() {
        return Collections.unmodifiableList(participants);
    }

    public List<Car> getWinners() {
        Integer leadingPosition = getLeadingPosition();
        return participants.stream()
                .filter(car -> leadingPosition.equals(car.getPosition()))
                .toList();
    }

    private Integer getLeadingPosition() {
        return participants.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }
}
