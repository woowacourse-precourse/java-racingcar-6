package racingcar.domain;

public class Progress {
    private int progress;

    Progress() {
        progress = 0;
    }

    void up() {
        progress++;
    }

    int get() {
        return progress;
    }
}
