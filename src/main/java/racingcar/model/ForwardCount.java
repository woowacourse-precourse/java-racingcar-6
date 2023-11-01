package racingcar.model;

import racingcar.enums.OutputMessage;
import racingcar.view.OutputView;

public class ForwardCount {
    private Integer counter;

    public ForwardCount() {
        this.counter = 0;
    }

    public void increaseCount() {
        ++this.counter;
    }

    @Override
    public String toString() {
        String pattern = OutputMessage.PROGRESS_BAR_OF_CAR_FORWARD.getMessage();
        return pattern.repeat(this.counter);
    }
}
