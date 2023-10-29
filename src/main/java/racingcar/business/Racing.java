package racingcar.business;

import racingcar.ui.InputView;
import racingcar.ui.Output;

import java.util.List;

public class Racing {

    InputView inputView = new InputView();

    public void doRacing() {

        Output.GET_NAMES.print();
        List<String> names = inputView.getNames();

        Output.GET_GAME_COUNT.print();


    }
}
