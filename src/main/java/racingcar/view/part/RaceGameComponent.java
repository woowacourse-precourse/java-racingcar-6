package racingcar.view.part;

import java.util.stream.Stream;
import racingcar.dto.RaceGameResult;
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

}
