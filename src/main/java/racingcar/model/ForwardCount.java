package racingcar.model;

import racingcar.view.OutputView;

public class ForwardCount {
    private Integer counter;

    public ForwardCount() {
        this.counter = 0;
    }

    public void increaseCount() {
        ++this.counter;
    }

    public void printProgressBar() {
        OutputView.printProgressAfterCarForward(this.counter);
    }
}
