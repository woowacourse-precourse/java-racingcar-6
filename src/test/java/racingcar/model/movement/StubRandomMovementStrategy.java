package racingcar.model.movement;

public class StubRandomMovementStrategy implements MovementStrategy {
    private final int number;

    public StubRandomMovementStrategy(int number){
        this.number = number;
    }

    @Override
    public boolean canMove(){
        return number > 3;
    }
}
