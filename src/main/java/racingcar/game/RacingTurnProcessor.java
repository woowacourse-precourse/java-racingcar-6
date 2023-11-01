package racingcar.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import racingcar.game.vo.RacerPosition;
import racingcar.race.Racer;
import racingcar.race.RacerRegistry;

public class RacingTurnProcessor<T extends Racer> {
    private final List<T> racers = new ArrayList<>();

    public RacingTurnProcessor(RacerRegistry<T> racerRegistry) {
        this.racers.addAll(racerRegistry.getRacers());
    }

    public void progressTurn() {
        for (T racer : racers) {
            racer.move();
        }
    }

    public List<RacerPosition> getRacerPositions() {
        return racers.stream()
                .map(racingCar -> new RacerPosition(racingCar.getName(), racingCar.getPosition()))
                .toList();
    }

    public List<String> getWinners() {
        Optional<Integer> maxPosition = racers.stream()
                .map(Racer::getPosition)
                .max(Integer::compareTo);

        return maxPosition.map(max -> racers.stream()
                        .filter(racer -> racer.getPosition() == max)
                        .map(Racer::getName)
                        .toList())
                .orElse(Collections.emptyList());
    }

    @Override
    public String toString() {
        return "RacingTurnProcessor{" +
                "racers=" + racers +
                '}';
    }
}
