package racingcar.domain;

public class car {
    private int position = 0;

    public void go() {
        position++;
    }

    public void stop() {
    }

    public int getPosition() {
        return position;
    }


}
