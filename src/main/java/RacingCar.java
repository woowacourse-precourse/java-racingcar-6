import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    String name;
    int moveCount;

    public RacingCar(String name) {
        this.name = name;
    }
    private int rollDice() {
        int diceNumber = Randoms.pickNumberInRange(0,9);
        return diceNumber;
    }
    private void move(int diceNumber) {
        if (4 <= diceNumber) moveCount++;
    }
    public int showMoveCount() {
        return moveCount;
    }
}
