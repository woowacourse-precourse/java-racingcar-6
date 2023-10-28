package racingcar.model;

public class Round {
    private int round;

    public Round(String inputString) {
        // inputString에 대한 검사
        round = Integer.parseInt(inputString);
    }

    public boolean isRoundRemains() {
        return round > 0;
    }

    public void subtractOneRound() {
        round -= 1;
    }
}
