package racingcar;

import java.util.List;

public class RacingGameService {
    private final InputView inputView = new InputView();

    private int getPlayCount(){
        return inputView.playCount();
    }

    private List<String> getCarNameList(){
        return inputView.carNameList();
    }

}
