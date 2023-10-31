package racingcar.model.data;

import static racingcar.util.GameConstants.INITIAL_POSITION;

public class Position {
    private int position;

    public Position() {
        this.position = INITIAL_POSITION;
    }

    public int getPosition() {
        return this.position;
    }

    public void forward() {
        ++this.position;
    }
}
