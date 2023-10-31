package racingcar.round;

public class Round {

    private Integer round;

    public Round(String round) {
        this.round = StringToInteger(round);
    }

    public Integer StringToInteger(String round) {
        return Integer.parseInt(round);
    }

    public Integer getRound() {
        return round;
    }

    public void decreaseRound() {
        this.round--;
    }
}
