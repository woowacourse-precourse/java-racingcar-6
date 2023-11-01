package racingcar.domain.utils;

public class MoveStrategy {
    private MoveStrategy(){}
    public static final boolean isMovable(int pickedNumber){
        return pickedNumber >= 4;
    }
}
