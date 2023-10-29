package racingcar;

import java.util.List;
import racingcar.view.InputView;

public class Game {

    private int tryCount;
    private List<Car> carList;

    public void run(){
        String[] car = InputView.readCarName();
        tryCount = InputView.readTryCount();
    }
}
