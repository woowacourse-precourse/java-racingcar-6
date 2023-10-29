package racingcar;

public class Racingcar {
    private final String name;
    private int moveDistance;

    public Racingcar(String name){
        this.name = name;
        this.moveDistance = 0;
    }

    public String getName() {
        return name;
    }

    public int getMoveDistance() {
        return moveDistance;
    }
    public void upMoveDistance(){
        this.moveDistance++;
    }
}
