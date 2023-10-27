package racingcar;

public class Race {
    private int moveNum;

    public void play() {
        inputCarNames();
        inputMovingNumber();

        for (int num = 0; num < moveNum; num++) {
            updateCarsPosition();
            displayCarMoving();
        }

        decideWinner();
        displayWinner();
    }

    private void inputCarNames() {

    }

    private void inputMovingNumber() {

    }

    private void updateCarsPosition() {

    }

    private void displayCarMoving() {

    }

    private void decideWinner() {

    }

    private void displayWinner() {

    }
}