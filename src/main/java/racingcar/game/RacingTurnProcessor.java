package racingcar.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import racingcar.common.config.RacingCarRule;
import racingcar.domain.RacerRegistry;
import racingcar.domain.racer.Racer;
import racingcar.game.vo.RacerPosition;
import racingcar.util.Random;

public class RacingTurnProcessor<T extends Racer> {
    private final Random random;
    private final List<T> racers = new ArrayList<>();

    public RacingTurnProcessor(Random random, RacerRegistry<T> racerRegistry) {
        this.random = random;
        this.racers.addAll(racerRegistry.getRacers());
    }

    public void progressTurn() {

        for (T racer : racers) {
            racer.move(random.getRandomNumberInRange(RacingCarRule.RANDOM_NUMBER_MIN, RacingCarRule.RANDOM_NUMBER_MAX));
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
