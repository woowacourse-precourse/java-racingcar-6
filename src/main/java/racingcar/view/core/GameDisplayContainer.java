package racingcar.view.core;

import java.util.List;
import racingcar.event.core.EventListener;
import racingcar.view.part.CheckWinnerResultComponent;
import racingcar.view.part.InitializeRacingGameComponent;
import racingcar.view.part.RaceGameComponent;

public class GameDisplayContainer {

    private final List<ScreenComponent> screenComponents;

    public GameDisplayContainer(InputView inputView, OutputView outputView, EventListener eventListener) {
        screenComponents = List.of(
                new InitializeRacingGameComponent(inputView, eventListener),
                new RaceGameComponent(outputView, eventListener),
                new CheckWinnerResultComponent(outputView, eventListener)
        );
    }

    public void renderAll() {
        screenComponents.forEach(ScreenComponent::render);
    }

}
