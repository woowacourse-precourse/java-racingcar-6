package racingcar.view.part;

import java.util.List;
import racingcar.event.core.EventListener;
import racingcar.view.core.OutputView;
import racingcar.view.core.ScreenComponent;
import racingcar.view.part.RaceGameComponent.RaceGameResult.TrackPerResult;

public record RaceGameComponent(OutputView outputView, EventListener eventListener) implements ScreenComponent {
    @Override
    public void render() {
        final List<TrackPerResult> trackPerResult = List.of(new TrackPerResult("pobi", 5), new TrackPerResult("jaehong", 3));
        outputView.printTrackPerResult(trackPerResult);
    }

    public record RaceGameResult(List<TrackPerResult> trackPerResults) {
        public record TrackPerResult(String name, int distance) {

        }
    }
}
