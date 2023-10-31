package racingcar.model.movement;

public class MovementStrategyFactory {
    public static MovementStrategy createDefault(){
        return new RandomMovementStrategy();
    }

}
