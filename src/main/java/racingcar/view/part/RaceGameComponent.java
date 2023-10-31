package racingcar.view.part;

import java.util.List;
import java.util.stream.Stream;
import racingcar.event.core.EventListener;
import racingcar.event.part.RaceGameEvent;
import racingcar.view.core.OutputView;
import racingcar.view.core.ScreenComponent;

public record RaceGameComponent(OutputView outputView, EventListener eventListener) implements ScreenComponent {
    @Override
    public void render() {
        Stream.generate(() -> eventListener.listenWithResult(RaceGameEvent::new))
                .takeWhile(RaceGameResult::isNotCompleted)
                .map(RaceGameResult::trackPerResults)
                .forEach(outputView::printTrackPerResult);
    }

    public record RaceGameResult(boolean isCompleted, List<TrackPerResult> trackPerResults) {
        public boolean isNotCompleted() {
            return !isCompleted;
        }

        public record TrackPerResult(String name, int distance) {

        }
    }
}
