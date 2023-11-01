package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public record RaceCars(List<RaceCar> raceCars) {

    public void moveCars() {
        for (RaceCar raceCar : raceCars) {
            raceCar.moveForward();
        }
    }

    public List<RaceCar> getWinners() {
        Position maxPosition = getMaxPosition();

        return raceCars.stream().filter(raceCar -> raceCar.getPosition().equals(maxPosition))
                .collect(Collectors.toList());
    }

    private Position getMaxPosition() {
        return raceCars.stream().map(RaceCar::getPosition).max(Position::compareTo).orElse(new Position(0));
    }
}
