package racingcar.domain;

public class Try {

    private int count;

    public Try(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public void tryRace() {
        this.count--;
    }

    public boolean isRaceOver() {
        return this.count == 0;
    }

}
