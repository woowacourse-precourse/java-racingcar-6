package racingcar.service;

import racingcar.domain.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class TryService {


    public TryCount getTryCount(){
        OutputView.inputCountNumberMessage();
        return new TryCount(InputView.readCountNumber());
    }
}
