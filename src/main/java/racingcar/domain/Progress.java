package racingcar.domain;

public class Progress {
    private int progress;

    Progress() {
        progress = 0;
    }

    void move() {
        progress++;
    }

    int get() {
        return progress;
    }
}
