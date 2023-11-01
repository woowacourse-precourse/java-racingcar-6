package racingcarv2.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcarv2.view.OutputView;

public abstract class AbstractController implements Controller {
    @Override
    public void process() {
        try {
            run();
        } catch (IllegalArgumentException e) {
            OutputView.printMessage(e.getMessage());
            Console.close();
            throw new IllegalArgumentException(e.getMessage());
        }
    }
    abstract void run();
}
