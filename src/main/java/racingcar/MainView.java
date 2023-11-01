package racingcar;

import racingcar.data.RacingCarRepository;
import racingcar.event.core.EventListener;
import racingcar.view.core.GameDisplayContainer;
import racingcar.view.core.InputView;
import racingcar.view.core.OutputView;

public class MainView {

    public void open() {
        new GameDisplayContainer(new InputView(),
                new OutputView(),
                new EventListener(new RacingCarRepository())
        ).renderAll();
    }
}
