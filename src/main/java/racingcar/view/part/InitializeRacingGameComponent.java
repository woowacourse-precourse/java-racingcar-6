package racingcar.view.part;

import racingcar.event.core.EventListener;
import racingcar.view.core.InputView;
import racingcar.view.core.ScreenComponent;

public record InitializeRacingGameComponent(InputView inputView, EventListener eventListener) implements ScreenComponent {

    @Override
    public void render() {
        final var carNames = inputView.readParticipantCarNames();
        final var retryCount = inputView.readExtractLapCount();
    }
}
