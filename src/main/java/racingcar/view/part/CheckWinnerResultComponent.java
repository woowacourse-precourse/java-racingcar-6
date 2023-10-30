package racingcar.view.part;

import java.util.List;
import racingcar.event.core.EventListener;
import racingcar.view.core.OutputView;
import racingcar.view.core.ScreenComponent;

public record CheckWinnerResultComponent(OutputView outputView, EventListener eventListener) implements ScreenComponent {
    @Override
    public void render() {
        this.outputView.printWinner(List.of("1", "2"));
    }
}
