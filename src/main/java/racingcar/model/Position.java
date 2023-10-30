package racingcar.model;

import static racingcar.constants.Constants.SLASH;


public class Position {
    private int position;

    public Position() {
        position = 0;
    }

    public Position(int status) {
        position = status;
    }

    public void attemptForward() {
        RandomNumber randomNumber = new RandomNumber();

        if (randomNumber.checkValueIsOverFour()) {
            moveForward();
        }
    }

    private void moveForward() {
        position += 1;
    }

    public String getForwardState() {
        return switchCountToSlash();
    }

    private String switchCountToSlash() {
        return SLASH.repeat(position);
    }

    public int getPosition() {
        return position;
    }
}
