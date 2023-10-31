package racingcar;

import racingcar.data.DataStore;
import racingcar.event.core.EventListener;
import racingcar.view.core.GameDisplayContainer;
import racingcar.view.core.InputView;
import racingcar.view.core.OutputView;

public class Main {

    public void run() {
        final var displayContainer = new GameDisplayContainer(new InputView(), new OutputView(), new EventListener(new DataStore()));

        displayContainer.renderAll();
    }
}
