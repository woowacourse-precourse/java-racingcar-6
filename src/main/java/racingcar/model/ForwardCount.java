package racingcar.model;

public class ForwardCount {
    private Integer counter;

    public ForwardCount() {
        this.counter = 0;
    }

    public void increaseCount() {
        ++this.counter;
    }

    public void printCountToProgressBar() {
    }
}
