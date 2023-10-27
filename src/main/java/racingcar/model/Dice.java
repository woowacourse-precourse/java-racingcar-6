package racingcar.model;

public class Dice {
    private final DiceNumber diceNumber;

    public Dice(int diceNumber) {
        this.diceNumber = new DiceNumber(diceNumber);
    }

    public DiceNumber getDiceNumber() {
        return diceNumber;
    }
}
