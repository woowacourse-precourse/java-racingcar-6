package racingcar.view.part;

import java.util.List;
import java.util.stream.Stream;
import racingcar.domain.Car;
import racingcar.event.core.EventListener;
import racingcar.event.part.RaceGameEvent;
import racingcar.strategy.RandomRacingCarMoveStrategy;
import racingcar.view.core.OutputView;
import racingcar.view.core.ScreenComponent;

public record RaceGameComponent(OutputView outputView, EventListener eventListener) implements ScreenComponent {

    @Override
    public void render() {
        outputView.printRaceStartMessage();

        final var racingCarMoveStrategy = new RandomRacingCarMoveStrategy();
        final var raceGameEvent = eventListener.listenWithParameterAndResult(RaceGameEvent::new);

        Stream.generate(() -> raceGameEvent.apply(racingCarMoveStrategy))
                .takeWhile(RaceGameResult::isNotCompleted)
                .map(RaceGameResult::trackPerResults)
                .forEach(outputView::printTrackPerResult);
    }

    public record RaceGameResult(boolean isCompleted, List<TrackPerResult> trackPerResults) {

        public static RaceGameResult createAlreadyCompletedResult() {
            return new RaceGameResult(true, List.of());
        }

        public static RaceGameResult processGameResult(List<TrackPerResult> trackPerResults) {
            return new RaceGameResult(false, trackPerResults);
        }

        public boolean isNotCompleted() {
            return !isCompleted;
        }

        public record TrackPerResult(String name, int distance) {
            private static final String DISTANCE_UNIT = "-";

            public static TrackPerResult from(Car car) {
                return new TrackPerResult(car.getName(), car.getLap());
            }

            public String toResult() {
                return String.format("%s : %s", name, DISTANCE_UNIT.repeat(distance));
            }
        }
    }
}
