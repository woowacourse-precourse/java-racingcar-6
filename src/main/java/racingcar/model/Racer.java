package racingcar.model;

public class Racer {

    private String name;
    private int moveCount = 0;
    private boolean state = false;
    public String moveState = "";

    public Racer(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    public boolean getState() {
        return this.state;
    }

    public void increaseMoveCount() {
        this.moveCount += 1;
    }

    public void goState() {
        this.state = true;
        increaseMoveCount();
    }

    public void stopState() {
        this.state = false;
    }

    public String getMoveState() {
        return this.moveState;
    }
}
