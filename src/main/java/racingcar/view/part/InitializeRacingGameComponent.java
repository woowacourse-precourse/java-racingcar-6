package racingcar.view.part;

import racingcar.event.core.EventListener;
import racingcar.event.part.InitializeExtractTrackEvent;
import racingcar.event.part.InitializeParticipantsEvent;
import racingcar.view.core.InputView;
import racingcar.view.core.ScreenComponent;

public record InitializeRacingGameComponent(InputView inputView, EventListener eventListener) implements ScreenComponent {

    @Override
    public void render() {
        eventListener.listenWithParameter(InitializeParticipantsEvent::new)
                .accept(inputView.readParticipantCarNames());
        eventListener.listenWithParameter(InitializeExtractTrackEvent::new)
                .accept(inputView.readExtractLapCount());

    }
}
