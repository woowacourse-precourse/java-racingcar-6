package racingcar.service;

public class StubMovementStrategy implements MovementStrategy {
    private final int number;

    public StubMovementStrategy(int number){
        this.number = number;
    }

    @Override
    public boolean canMove(){
        return number > 3;
    }
}
