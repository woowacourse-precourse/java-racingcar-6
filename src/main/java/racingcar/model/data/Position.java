package racingcar.model.data;

import static racingcar.util.GameConstants.INITIAL_POSITION;

public class Position {
    int position;

    public Position() {
        this.position = INITIAL_POSITION;
    }

    public void forward() {
        ++this.position;
    }
}
