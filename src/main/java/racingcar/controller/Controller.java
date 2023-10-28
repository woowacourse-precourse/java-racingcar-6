package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Racing;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    Racing racing = new Racing();

    public void racingGame() {
        List<String> carNames = inputView.askName();
        int count = inputView.askGameCount();
        List<Integer> forwardCountList = forwardCount(carNames.size());
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < forwardCountList.size(); j++) {
                int step = forwardCountList.get(j);
                step += addCount();
                forwardCountList.set(j, step);
                outputView.showRacing(carNames.get(j), step);
            }
            System.out.println("");

        }

    }

    public List<Integer> forwardCount(int carNameSize) {
        List<Integer> forwardCountList = new ArrayList<>();
        for (int i = 0; i < carNameSize; i++) {
            forwardCountList.add(0);
        }
        return forwardCountList;
    }

    public int addCount() {
        if (racing.moveForward()) {
            return 1;
        }
        return 0;

    }
}