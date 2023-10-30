package racingcar.service;

public class MovementStrategyFactory {
    public static MovementStrategy createDefault(){
        return new RandomMovementStrategy();
    }

}
