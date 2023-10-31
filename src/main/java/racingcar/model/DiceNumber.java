package racingcar.model;

public class DiceNumber {

    private final int diceNumber;

    public DiceNumber(final int diceNumber) {
        validateDiceNumber(diceNumber);
        this.diceNumber = diceNumber;
    }

    private void validateDiceNumber(int diceNumber) {
        if (diceNumber < 0 || diceNumber > 9) {
            throw new IllegalArgumentException();
        }
    }

    public int getRawDiceNumber() {
        return diceNumber;
    }
}
