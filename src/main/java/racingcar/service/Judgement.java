package racingcar.service;

public class Judgement {

    public Judgement() {
    }

    public boolean isMovableRange(int random) {
        if (random >= 4) {
            return true;
        }

        return false;
    }

    public void findWinner() {

    }
}
