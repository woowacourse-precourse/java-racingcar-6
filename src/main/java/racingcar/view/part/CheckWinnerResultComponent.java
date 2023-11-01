package racingcar.view.part;

import racingcar.event.core.EventListener;
import racingcar.event.part.CollectWinnerEvent;
import racingcar.view.core.OutputView;
import racingcar.view.core.ScreenComponent;

public record CheckWinnerResultComponent(OutputView outputView, EventListener eventListener) implements ScreenComponent {
    @Override
    public void render() {
        final var winner = eventListener.listenWithResult(CollectWinnerEvent::new);

        outputView.printWinner(winner);
    }
}
